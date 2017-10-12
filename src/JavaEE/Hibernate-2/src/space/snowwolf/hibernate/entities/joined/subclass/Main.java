package space.snowwolf.hibernate.entities.joined.subclass;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Main {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		Configuration config = new Configuration().configure();
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		factory = config.buildSessionFactory(registry);
		session = factory.openSession();
		transaction = session.beginTransaction();
	}

	@After
	public void destory() {
		transaction.commit();
		session.close();
		factory.close();
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testGet() {
		List<Person> persons = session.createQuery("FROM Person").list();
		System.out.println(persons.size());
		
		List<Student> students = session.createQuery("FROM Student").list();
		System.out.println(students.size());
	}
	
	@Test
	public void testSave() {
		Person person = new Person();
		person.setAge(11);
		person.setName("AA");
		session.save(person);
		
		Student student = new Student();
		student.setAge(22);
		student.setName("BB");
		student.setSchool("snowwolf.space");
		session.save(student);
	}
	
	@Test
	public void test() {
		
	}
}
