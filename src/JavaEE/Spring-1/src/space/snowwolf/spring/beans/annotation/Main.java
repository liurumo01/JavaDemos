package space.snowwolf.spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import space.snowwolf.spring.beans.annotation.controller.UserController;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");
		
		/*TestObject to = (TestObject) context.getBean("testObject");
		System.out.println(to);*/
		
		UserController userController = (UserController) context.getBean("userController");
		System.out.println(userController);
		
		userController.execute();
	}
}
