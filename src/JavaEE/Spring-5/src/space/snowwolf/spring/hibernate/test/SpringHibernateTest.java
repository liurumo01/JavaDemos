package space.snowwolf.spring.hibernate.test;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import space.snowwolf.spring.hibernate.service.BookShopService;
import space.snowwolf.spring.hibernate.service.Cashier;

public class SpringHibernateTest {
	
	private ApplicationContext context = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopService = context.getBean(BookShopService.class);
		cashier = context.getBean(Cashier.class);
	}
	
	@Test
	public void testCashier() {
		cashier.checkout("AA", Arrays.asList("1001", "1002"));
	}
	
	@Test
	public void testBookShopService() {
		bookShopService.purchase("AA", "1001");
	}

	@Test
	public void testDataSourse() throws SQLException {
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}

}
