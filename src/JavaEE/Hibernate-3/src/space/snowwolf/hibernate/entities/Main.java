package space.snowwolf.hibernate.entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import space.snowwolf.hibernate.dao.DepartmetDAO;
import space.snowwolf.hibernate.dao.HibernateUtils;

@SuppressWarnings("unchecked")
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
	public void testManageSession() {
		Session session = HibernateUtils.getInstance().getSession();
		Transaction transaction = session.beginTransaction();
		
		Department department = new Department();
		department.setName("AAAA");
		
		DepartmetDAO dao = new DepartmetDAO();
		dao.save(department);
		dao.save(department);
		dao.save(department);
		
		transaction.commit();
		System.out.println(session.isOpen());
	}
	
	@Test
	public void testHQLNamedParameters() {
		String hql = "FROM Employee e where e.salary > :salary AND e.email like :email";
		Query query = session.createQuery(hql);

		query.setFloat("salary", 2000).setString("email", "%qw%");

		List<Employee> employees = query.list();
		System.out.println(employees);
	}

	@Test
	public void testHQL() {
		String hql = "FROM Employee e where e.salary > ? AND e.email like ? AND e.department = ? ORDER BY e.salary";
		Query query = session.createQuery(hql);

		Department department = new Department();
		department.setId(1);
		query.setFloat(0, 2000).setString(1, "%q%").setEntity(2, department);

		List<Employee> employees = query.list();
		System.out.println(employees);
	}

	@Test
	public void testPageQuery() {
		String hql = "From Employee";
		Query query = session.createQuery(hql);

		int pageNo = 6;
		int pageSize = 5;

		query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize);
		List<Employee> employees = query.list();
		System.out.println(employees);
	}
	
	@Test
	public void testNamedQuery() {
		Query query = session.getNamedQuery("salaryEmployees");
		List<Employee> employees = query.setFloat("minSalary", 3000).setFloat("maxSalary", 4000).list();
		System.out.println(employees);	
	}
	
	@Test
	public void testFieldQuery() {
		String hql = "SELECT e.email, e.salary, e.department FROM Employee e WHERE e.department = :department";
		Query query = session.createQuery(hql);
		
		Department department = new Department();
		department.setId(2);
		List<Object[]> result = query.setEntity("department", department).list();
		for(Object[] objs : result) {
			System.out.println(Arrays.asList(objs));
		}
	}
	
	@Test
	public void testFieldQuery2() {
		String hql = "SELECT new Employee(e.email, e.salary, e.department) FROM Employee e WHERE e.department = :department";
		Query query = session.createQuery(hql);
		
		Department department = new Department();
		department.setId(2);
		List<Employee> result = query.setEntity("department", department).list();
		for(Employee employee : result) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void testGroupBy() {
		String hql = "SELECT min(e.salary), max(e.salary) FROM Employee e GROUP BY e.department HAVING min(e.salary) > :minSalary";
		Query query = session.createQuery(hql).setFloat("minSalary", 800);
		
		List<Object[]> result = query.list();
		for(Object[] objs : result) {
			System.out.println(Arrays.asList(objs));
		}
		
	}
	
	@Test
	public void testLeftJoinFetch() {
		//String hql = "SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.employees";
		String hql = "FROM Department d LEFT JOIN FETCH d.employees";
		Query query = session.createQuery(hql);
		
		
		List<Department> departments = query.list();
		departments = new ArrayList<Department>(new HashSet<Department>(departments));
		System.out.println(departments.size());
		
		for(Department department : departments) {
			System.out.println(department.getName() + " - " + department.getEmployees().size());
		}
	}
	
	@Test
	public void testLeftJoin() throws IllegalArgumentException, IllegalAccessException {
		String hql = "SELECT DISTINCT d FROM Department d LEFT JOIN d.employees";
		Query query = session.createQuery(hql);
		
		List<Department> list = query.list();
		for(Department department : list) {
			System.out.println(department + " - " + department.getEmployees().size());
		}
	}
	
	@Test
	public void testQBC() {
		Criteria criteria = session.createCriteria(Employee.class);
		Conjunction conjunction = Restrictions.conjunction();
		conjunction.add(Restrictions.like("name", "aa"));
		
		Department department = new Department();
		department.setId(1);
		conjunction.add(Restrictions.eq("department", department));
		System.out.println(conjunction);
		
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.ge("salary", 1200f));
		disjunction.add(Restrictions.isNotNull("email"));
		
		criteria.add(conjunction);
		criteria.add(disjunction);
		
		System.out.println(criteria.list());
	}
	
	@Test
	public void testQBC2() {
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("email", "aaqw@snowwolf.space")).add(Restrictions.gt("salary", 800f));
		Employee employee = (Employee) criteria.uniqueResult();
		System.out.println(employee);
		
	}
	
	@Test
	public void testQBC3() {
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.max("salary"));
		System.out.println(criteria.uniqueResult());
	}
	
	@Test
	public void testQBC4() {
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("salary")).addOrder(Order.desc("email"));
		
		int pageSize = 5;
		int pageNo = 3;
		List<Employee> employees = criteria.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		System.out.println(employees);
	}
	
	@Test
	public void testNativeSQL() {
		String sql = "INSERT INTO DEPARTMENTS VALUES (?, ?)";
		Query query = session.createSQLQuery(sql);
		query.setInteger(0, 5).setString(1, "文化部").executeUpdate();
	}
	
	@Test
	public void testQueryIterate() {
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		
		Iterator<Employee> it = query.iterate();
		int count = 0;
		while(it.hasNext()) {
			System.out.println(it.next().getName());
			count++;
		}
		System.out.println(count);
	}
	
	@Test
	public void testBatch() {
		session.doWork(new Work() {
			@Override
			public void execute(Connection arg0) throws SQLException {
				
			}
		});
	}
}
