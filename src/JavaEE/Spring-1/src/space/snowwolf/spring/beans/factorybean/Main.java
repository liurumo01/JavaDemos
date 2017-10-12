package space.snowwolf.spring.beans.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-factoryBean.xml");
		
		Car car1 = (Car) context.getBean("car1");
		System.out.println(car1);
	}
}
