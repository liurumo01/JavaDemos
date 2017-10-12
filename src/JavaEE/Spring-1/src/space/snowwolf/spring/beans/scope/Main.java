package space.snowwolf.spring.beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import space.snowwolf.spring.beans.autowire.Car;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-scope.xml");
		
		Car car = (Car) context.getBean("car");
		Car car2 = (Car) context.getBean("car");
		System.out.println(car == car2);
	}
}
