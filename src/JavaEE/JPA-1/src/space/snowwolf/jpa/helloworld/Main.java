package space.snowwolf.jpa.helloworld;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.show_sql", true);
		EntityManagerFactory factory = 
				//Persistence.createEntityManagerFactory("JPA-1");
				Persistence.createEntityManagerFactory("JPA-1", properties);

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		Customer customer = new Customer();
		customer.setAge(12);
		customer.setEmail("tom@163.com");
		customer.setName("Tom");
		customer.setBirth(new Date());
		customer.setCreateTime(new Date());

		manager.persist(customer);

		transaction.commit();

		manager.close();

		factory.close();
	}
}
