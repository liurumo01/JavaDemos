package space.snowwolf.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		helloWorld.hello();
		
		Car car1 = (Car) context.getBean("car1");
		System.out.println(car1);
		
		Car car2 = (Car) context.getBean("car2");
		System.out.println(car2);
		
		Person person1 = (Person)context.getBean("person1");
		System.out.println(person1);
		
		Person person2 = (Person)context.getBean("person2");
		System.out.println(person2);
		
		Person person3 = (Person)context.getBean("person3");
		System.out.println(person3);
	}
}
