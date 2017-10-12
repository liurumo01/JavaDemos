package space.snowwolf.hibernate.entities;

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
	public void testComponent() {
		Worker worker = new Worker();
		Pay pay = new Pay();
		
		pay.setMonthlyPay(1000);
		pay.setYearlyPay(80000);
		pay.setVocationWithPay(5);
		worker.setName("ABCD");
		worker.setPay(pay);
		
		session.save(worker);
	}
	/*
	@Test
	public void testBlob() throws IOException, SQLException {
		//saveBlob();
		loadBlob();
	}
	
	public void saveBlob() throws IOException {
		News news = new News("AA", "Snowwolf", new Date());
		
		InputStream stream = new FileInputStream("a.jpg");
		Blob image = Hibernate.getLobCreator(session).createBlob(stream, stream.available());
		news.setImage(image);
		
		session.save(news);
	}
	
	public void loadBlob() throws SQLException, IOException {
		News news = (News) session.get(News.class, 4);
		System.out.println(news);
		Blob blob = news.getImage();
		
		InputStream in = blob.getBinaryStream();
		System.out.println(in.available());
		
		OutputStream out = new FileOutputStream("b.jpg");
		
		int len = 0;
		byte[] buf = new byte[1024];
		while((len = in.read(buf, 0, 1024)) > 0) {
			out.write(buf, 0, len);
		}
		
		in.close();
		out.close();
		
	}

	@Test
	public void testLoad() {
		News news = (News) session.load(News.class, 1);
		System.out.println(news.getClass().getName());
		System.out.println(news);
		System.out.println(news.getClass().getName());
	}

	@Test
	public void testGet() {
		News news = (News) session.get(News.class, 1);
		System.out.println(news);
	}

	@Test
	public void testPersist() {
		News news = new News("DD", "dd", new Date(new java.util.Date().getTime()));
		news.setId(200);
		System.out.println(news);
		session.persist(news);
		System.out.println(news);
	}

	@Test
	public void testSave() {
		News news = new News("AA", "aa", new Date(new java.util.Date().getTime()));
		System.out.println(news);
		session.save(news);
		System.out.println(news);
	}

	@Test
	public void testUpdate() {
		News news = (News) session.get(News.class, 6);

		transaction.commit();
		session.close();

		session = factory.openSession();
		transaction = session.beginTransaction();

		// news.setAuthor("SUN");
		session.update(news);
	}

	@Test
	public void testDelete() {
		News news = new News();
		news.setId(6);

		session.delete(news);

		System.out.println(news);
	}

	@Test
	public void testDoWork() {
		session.doWork(new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println(connection);
			}

		});
	}

	@Test
	public void testSessionCache() {
		News news = (News) session.get(News.class, 1);
		System.out.println(news);

		News news2 = (News) session.get(News.class, 1);
		System.out.println(news2);
	}

	@Test
	public void testSessionFlush() {
		News news = (News) session.get(News.class, 1);
		news.setAuthor("Oracle");
		session.save(news);
	}
	*/
}
