package space.snowwolf.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggingAspect {
	
	@Pointcut("execution(* space.snowwolf.spring.aop.*.*(int, int))")
	public void declareJoinPointExpression() {
		
	}

	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with" + args);
	}

	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}

	@AfterReturning(value = "declareJoinPointExpression()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}

	@AfterThrowing(value = "declareJoinPointExpression()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception " + ex);
	}

	@AfterThrowing(value = "declareJoinPointExpression()", throwing = "ex")
	public void afterThrowing2(JoinPoint joinPoint, NullPointerException ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception " + ex);
	}

//	@Around("execution(* space.snowwolf.spring.aop.*.*(int, int))")
//	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
//		Object result = null;
//		String methodName = proceedingJoinPoint.getSignature().getName();
//		Object[] args = proceedingJoinPoint.getArgs();
//		try {
//			System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
//			result = proceedingJoinPoint.proceed();
//			System.out.println("The method " + methodName + " ends with " + result);
//		} catch (Throwable e) {
//			System.out.println("The method occurs exception " + e);
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//		System.out.println("The method " + methodName + " ends");
//		return result;
//	}

}
