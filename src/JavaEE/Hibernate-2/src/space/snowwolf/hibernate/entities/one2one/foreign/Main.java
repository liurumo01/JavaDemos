package space.snowwolf.hibernate.entities.one2one.foreign;

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
	public void testGet2() {
		Manager manager = (Manager) session.get(Manager.class, 1);
		System.out.println(manager.getManagerName());
		
		System.out.println(manager.getDepartment().getDepartmentName());
	}
	
	@Test
	public void testGet() {
		Department department = (Department) session.get(Department.class, 1);
		System.out.println(department.getDepartmentName());
		
		Manager manager = department.getManager();
		System.out.println(manager.getManagerName());
	}
	
	@Test
	public void testSave() {
		Department department = new Department();
		department.setDepartmentName("BB");
		
		Manager manager = new Manager();
		manager.setManagerName("bb");
		
		department.setManager(manager);
		manager.setDepartment(department);
		
		session.save(department);
		session.save(manager);
	}
	
	@Test
	public void test() {
		
	}
}
