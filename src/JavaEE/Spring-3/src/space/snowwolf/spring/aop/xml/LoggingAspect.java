package space.snowwolf.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
	public void declareJoinPointExpression() {
		
	}

	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with" + args);
	}

	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}

	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}

	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception " + ex);
	}

	public void afterThrowing2(JoinPoint joinPoint, NullPointerException ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception " + ex);
	}

	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
		Object result = null;
		String methodName = proceedingJoinPoint.getSignature().getName();
		Object[] args = proceedingJoinPoint.getArgs();
		try {
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
			result = proceedingJoinPoint.proceed();
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			System.out.println("The method occurs exception " + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		System.out.println("The method " + methodName + " ends");
		return result;
	}

}
