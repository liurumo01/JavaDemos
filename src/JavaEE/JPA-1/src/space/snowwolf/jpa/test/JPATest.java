package space.snowwolf.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.ejb.QueryHints;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import space.snowwolf.jpa.helloworld.Customer;

public class JPATest {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private EntityTransaction transaction;
	
	@Test
	@SuppressWarnings("unchecked")
	public void testQueryCache() {
		String jpql = "from Customer c where c.age > ?";
		Query query = entityManager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE, true);
		
		query.setParameter(1, 1);
		List<Customer> customers = query.getResultList();
		System.out.println(customers.size());
		
		query = entityManager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE, true);
		
		query.setParameter(1, 1);
		customers = query.getResultList();
		System.out.println(customers.size());
	}
	
	@Test
	public void testNativeQuery() {
		String sql = "select age from customers where id = ?";
		Query query = entityManager.createNativeQuery(sql).setParameter(1, 3);
		Object result = query.getSingleResult();
		System.out.println(result);
	}
	
	@Test
	public void testNamedQuery() {
		Query query = entityManager.createNamedQuery("testNamedQuery").setParameter(1, 2);
		Customer customer = (Customer) query.getSingleResult();
		System.out.println(customer);
	}
	
	@Test
	public void testPartlyProperties() {
		String jpql = "select new Customer(c.name, c.age) from Customer c where c.id > ?";
		List<?> result = entityManager.createQuery(jpql).setParameter(1, 1).getResultList();
		System.out.println(result);
	}
	
	@Test
	public void testHelloJPQL() {
		String jpql = "from Customer c where c.age > ?";
		Query query = entityManager.createQuery(jpql);
		
		query.setParameter(1, 1);
		@SuppressWarnings("unchecked")
		List<Customer> customers = query.getResultList();
		System.out.println(customers.size());
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testSecondLevelCache() {
		Customer customer = entityManager.find(Customer.class, 2);
		
		transaction.commit();
		entityManager.close();
		
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		
		Customer customer2 = entityManager.find(Customer.class, 2);
	}
	
	@Test
	public void testManyToMany() {
		
	}
	
	@Test
	public void testOneToMany() {
		
	}
	
	/*
	
	@Test
	public void testManyToOneUpdate() {
		Order order = entityManager.find(Order.class, 4);
		order.getCustomer().setName("FFF");
	}
	
	@Test
	public void testManyToOneRemove() {
//		Order order = entityManager.find(Order.class, 3);
//		entityManager.remove(order);
		Customer customer = entityManager.find(Customer.class, 2);
		entityManager.remove(customer);
	}
	
	@Test
	public void testManyToOneFind() {
		Order order = entityManager.find(Order.class, 3);
		System.out.println(order);
		System.out.println(order.getCustomer());
	}
	
	@Test
	public void testManyToOnePersist() {
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setEmail("ff@163.com");
		customer.setName("FF");
		
		Order order1 = new Order();
		order1.setName("O-FF-1");
		Order order2 = new Order();
		order2.setName("O-FF-2");
		
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		entityManager.persist(order1);
		entityManager.persist(order2);
		entityManager.persist(customer);
	}
	
	@Test
	public void testRefresh() {
		Customer customer = entityManager.find(Customer.class, 3);
		customer = entityManager.find(Customer.class, 3);
		entityManager.refresh(customer);
	}
	
	@Test
	public void testFlush() {
		Customer customer = entityManager.find(Customer.class, 3);
		System.out.println(customer);
		customer.setName("BB");
		entityManager.flush();
	}
	
	@Test
	public void testMerge4() {
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setEmail("dd@163.com");
		customer.setName("DD");
		
		customer.setId(4);
		
		Customer customer2 = entityManager.find(Customer.class, 4);
		entityManager.merge(customer);
		System.out.println(customer == customer2);
	}
	
	@Test
	public void testMerge3() {
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setEmail("ee@163.com");
		customer.setName("EE");
		
		customer.setId(2);
		
		Customer customer2 = entityManager.merge(customer);
		System.out.println(customer == customer2);
	}
	
	@Test
	public void testMerge2() {
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setEmail("dd@163.com");
		customer.setName("DD");
		
		customer.setId(100);
		
		Customer customer2 = entityManager.merge(customer);
		System.out.println(customer.getId() + " - " + customer2.getId());
	}
	
	@Test
	public void testMerge1() {
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setEmail("cc@163.com");
		customer.setName("cc");
		
		Customer customer2 = entityManager.merge(customer);
		System.out.println(customer.getId() + " - " + customer2.getId());
	}
	
	@Test
	public void testRemove() {
		//Customer customer = new Customer();
		//customer.setId(1);
		Customer customer = entityManager.find(Customer.class, 1);
		entityManager.remove(customer);
	}

	@Test
	public void testPersist() {
		Customer customer = new Customer();
		customer.setAge(10);
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());
		customer.setEmail("bb@163.com");
		customer.setName("AA");
		
		entityManager.persist(customer);
		System.out.println(customer.getId());
	}
	
	@Test
	public void testGetReference() {
		Customer customer = entityManager.getReference(Customer.class, 1);
		System.out.println(customer.getClass().getName());
		System.out.println("----------");
		System.out.println(customer);
	}
	
	@Test
	public void testFind() {
		Customer customer = entityManager.find(Customer.class, 1);
		System.out.println(customer.getClass().getName());
		System.out.println("----------");
		System.out.println(customer);
	}
	
	*/
	
	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("JPA-1");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
	}
	
	@After
	public void destory() {
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
