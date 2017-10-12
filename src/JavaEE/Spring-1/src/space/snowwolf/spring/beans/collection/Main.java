package space.snowwolf.spring.beans.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Person person4 = (Person) context.getBean("person4");
		System.out.println(person4);
		
		Person2 person5 = (Person2) context.getBean("person5");
		System.out.println(person5);
		
		DataSource source = (DataSource) context.getBean("dataSource");
		System.out.println(source);
		
		Person person6 = (Person) context.getBean("person6");
		System.out.println(person6);
		
		Person person7 = (Person) context.getBean("person7");
		System.out.println(person7);
	}
}
