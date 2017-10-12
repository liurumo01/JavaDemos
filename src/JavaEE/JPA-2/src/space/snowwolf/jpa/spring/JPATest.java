package space.snowwolf.jpa.spring;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import space.snowwolf.jpa.spring.entities.Person;
import space.snowwolf.jpa.spring.service.PersonService;

public class JPATest {
	
	private ApplicationContext context = null;
	private PersonService personService = null;
	
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		personService = context.getBean(PersonService.class);
	}
	
	@Test
	public void testPersonService() {
		Person p1 = new Person();
		p1.setAge(11);
		p1.setEmail("aa@163.com");
		p1.setName("AA");
		
		int i = 10 / 0;
		System.out.println(i);
		
		Person p2 = new Person();
		p2.setAge(12);
		p2.setEmail("bb@163.com");
		p2.setName("BB");
		
		System.out.println(personService.getClass().getName());
		personService.savePersons(p1, p2);
	}

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
