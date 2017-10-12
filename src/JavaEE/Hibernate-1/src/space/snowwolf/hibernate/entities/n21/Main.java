package space.snowwolf.hibernate.entities.n21;

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
	public void testMany2OneDelete() {
		Customer customer = (Customer) session.get(Customer.class, 1);
		session.delete(customer);
	}
	
	@Test
	public void testMany2OneUpdate() {
		Order order = (Order) session.get(Order.class, 1);
		order.getCustomer().setCustomerName("AAA");
	}
	
	@Test
	public void testMany2OneGet() {
		Order order = (Order) session.get(Order.class, 1);
		System.out.println(order.getOrderName());
		System.out.println(order.getCustomer().getCustomerName());
		
		session.clear();
		
		
	}
	
	@Test
	public void testMany2One() {
		Customer customer = new Customer();
		customer.setCustomerName("BB");
		
		Order order1 = new Order();
		order1.setOrderName("ORDER-3");
		
		Order order2 = new Order();
		order2.setOrderName("ORDER-4");
		
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		/*session.save(customer);
		session.save(order1);
		session.save(order2);*/
		
		session.save(order1);
		session.save(order2);
		session.save(customer);
	}
	
}
