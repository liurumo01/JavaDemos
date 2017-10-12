package space.snowwolf.spring.tx;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {
	
	private ApplicationContext context;
	private BookShopDAO bookShopDAO;
	private BookShopService bookShopService;
	private Cashier cashier;
	
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDAO = context.getBean(BookShopDAO.class);
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
	
	@Test
	public void testBookShopDAOUpdateUserAccount() {
		bookShopDAO.updateUserAccount("AA", 200);
	}
	
	@Test
	public void testBookShopDAOUpdateBookStock() {
		bookShopDAO.updateBookStock("1001");
	}

	@Test
	public void testBookShopFindPriceByIsbn() {
		System.out.println(bookShopDAO.findBookPriceByIsbn("1001"));
	}

}
