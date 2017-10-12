package space.snowwolf.hibernate.entities.n2n;

import java.util.Set;

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
	public void testGet() {
		Category category1 = (Category) session.get(Category.class, 1);
		System.out.println(category1.getName());
		
		Set<Item> items = category1.getItems();
		System.out.println(items);
	}
	
	@Test
	public void testSave() {
		Category category1 = new Category();
		category1.setName("C-AA");
		Category category2 = new Category();
		category2.setName("C-BB");
		
		Item item1 = new Item();
		item1.setName("I-AA");
		Item item2 = new Item();
		item2.setName("I-BB");
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		category2.getItems().add(item1);
		category2.getItems().add(item2);
		
		item1.getCategories().add(category1);
		item1.getCategories().add(category2);
		item2.getCategories().add(category1);
		item2.getCategories().add(category2);
		
		session.save(category1);
		session.save(category2);
		
		session.save(item1);
		session.save(item2);
	}
	
	@Test
	public void test() {
		
	}
}
