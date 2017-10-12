package space.snowwolf.spring.beans.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import space.snowwolf.spring.beans.autowire.Address;
import space.snowwolf.spring.beans.autowire.Person;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-relation.xml");
		
		//Address person = (Address) context.getBean("address");
		//System.out.println(person);
		
		Address person2 = (Address) context.getBean("address2");
		System.out.println(person2);
		
		Person person = (Person) context.getBean("person");
		System.out.println(person);
	}
}
