package space.snowwolf.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidationAspect {
	
	@Before("space.snowwolf.spring.aop.LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("validate:" + Arrays.asList(joinPoint.getArgs()));
	}
}
