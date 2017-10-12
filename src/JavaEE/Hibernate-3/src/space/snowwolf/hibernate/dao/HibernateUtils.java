package space.snowwolf.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {

	private static HibernateUtils instance = new HibernateUtils();

	private HibernateUtils() {
	}

	public static HibernateUtils getInstance() {
		return instance;
	}

	private SessionFactory factory;

	public SessionFactory getFactory() {
		if (factory == null) {
			Configuration config = new Configuration().configure();
			ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
					.buildServiceRegistry();
			factory = config.buildSessionFactory(registry);
		}
		return factory;
	}

	public Session getSession() {
		return getFactory().getCurrentSession();
	}
}
