package space.snowwolf.hibernate.strategy;

import java.util.List;

import org.hibernate.Hibernate;
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
	public void testSetFetch2() {
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println(customer.getOrders().size());
	}
	
	@Test
	public void testSetFetch() {
		@SuppressWarnings("unchecked")
		List<Customer> customers = session.createQuery("From Customer").list();
		System.out.println(customers.size());
		
		for (Customer customer : customers) {
			if(customer.getOrders() != null) {				
				System.out.println(customer.getOrders().size());
			}
		}
	}
	
	@Test
	public void testSetBatchSize() {
		@SuppressWarnings("unchecked")
		List<Customer> customers = session.createQuery("From Customer").list();
		System.out.println(customers.size());
		
		for (Customer customer : customers) {
			if(customer.getOrders() != null) {				
				System.out.println(customer.getOrders().size());
			}
		}
	}
	
	@Test
	public void testOne2ManyLevelStrategy() {
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println(customer.getCustomerName());
		System.out.println(customer.getOrders().getClass());
		System.out.println(customer.getOrders().size());
		
		Order order = new Order();
		order.setOrderId(1);
		System.out.println(customer.getOrders().contains(order));
		
		Hibernate.initialize(customer.getOrders());
	}
	
	@Test
	public void testClassLevelStrategy() {
		Customer customer = (Customer) session.load(Customer.class, 1);
		System.out.println(customer.getClass());
	}
}
