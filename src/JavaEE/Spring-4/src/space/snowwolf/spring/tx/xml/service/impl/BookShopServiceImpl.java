package space.snowwolf.spring.tx.xml.service.impl;

import space.snowwolf.spring.tx.xml.BookShopDAO;
import space.snowwolf.spring.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDAO bookShopDAO;
	
	public void setBookShopDAO(BookShopDAO bookShopDAO) {
		this.bookShopDAO = bookShopDAO;
	}

	@Override
	public void purchase(String username, String isbn) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int price = bookShopDAO.findBookPriceByIsbn(isbn);
		bookShopDAO.updateBookStock(isbn);
		bookShopDAO.updateUserAccount(username, price);
	}

}
