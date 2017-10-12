package space.snowwolf.hibernate.dao;

import org.hibernate.Session;

import space.snowwolf.hibernate.entities.Department;

public class DepartmetDAO {
	
	public void save(Session session, Department department) {
		session.save(session);
	}
	
	public void save(Department department) {
		Session session = HibernateUtils.getInstance().getSession();
		System.out.println(session.hashCode());
		session.save(department);
	}
}
