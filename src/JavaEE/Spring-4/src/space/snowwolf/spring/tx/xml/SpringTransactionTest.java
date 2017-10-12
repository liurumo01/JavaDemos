package space.snowwolf.spring.tx.xml;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import space.snowwolf.spring.tx.xml.service.BookShopService;
import space.snowwolf.spring.tx.xml.service.Cashier;

public class SpringTransactionTest {
	
	private ApplicationContext context;
	private BookShopService bookShopService;
	private Cashier cashier;
	
	{
		context = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
		bookShopService = context.getBean(BookShopService.class);
		cashier = context.getBean(Cashier.class);
	}
	
	@Test
	public void testTransactionalPropagation() {
		cashier.checkout("AA", Arrays.asList("1001", "1002"));
	}
	
	@Test
	public void testBookShopService() {
		bookShopService.purchase("AA", "1001");
	}
}
