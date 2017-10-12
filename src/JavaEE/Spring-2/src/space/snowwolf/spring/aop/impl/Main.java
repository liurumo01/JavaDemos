package space.snowwolf.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArithmeticCalculator calculator = context.getBean(ArithmeticCalculator.class);
		int result = calculator.add(3, 6);
		System.out.println(result);
		
		result = calculator.mul(12, 6);
		System.out.println(result);
		
		result = calculator.div(12, 0);
		System.out.println(result);
	}
	
}
