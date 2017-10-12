package space.snowwolf.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import space.snowwolf.spring.hibernate.dao.BookShopDAO;
import space.snowwolf.spring.hibernate.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDAO bookShopDAO;

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
