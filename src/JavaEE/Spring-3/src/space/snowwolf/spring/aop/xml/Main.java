package space.snowwolf.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		
		ArithmeticCalculator calculator = (ArithmeticCalculator) context.getBean("arithmeticCalculator");
		System.out.println(calculator.getClass().getName());
		
		int result = calculator.add(1, 2);
		System.out.println(result);
		
		result = calculator.div(1000, 200);
		System.out.println(result);
		
//		result = calculator.div(1000, 0);
//		System.out.println(result);
	}
	
}
