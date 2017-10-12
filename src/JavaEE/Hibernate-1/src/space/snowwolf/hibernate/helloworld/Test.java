package space.snowwolf.hibernate.helloworld;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test {
	public static void main(String[] args) {
		SessionFactory factory = null;
		Configuration config = new Configuration().configure();
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		factory = config.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		News news = new News("Java", "Snowwolf", new Date(new java.util.Date().getTime()));
		session.save(news);
		transaction.commit();
		session.close();
		factory.close();
	}
}
