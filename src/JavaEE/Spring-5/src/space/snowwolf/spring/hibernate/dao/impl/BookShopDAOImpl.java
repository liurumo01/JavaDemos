package space.snowwolf.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import space.snowwolf.spring.hibernate.dao.BookShopDAO;
import space.snowwolf.spring.hibernate.exceptions.BookStockException;
import space.snowwolf.spring.hibernate.exceptions.UserAccountException;

@Repository
public class BookShopDAOImpl implements BookShopDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int findBookPriceByIsbn(String isbn) {
		String hql = "select b.price from Book b where b.isbn = ?";
		Query query = getSession().createQuery(hql).setString(0, isbn);
		return (int) query.uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn) {
		String hql2 = "select b.stock from Book b where b.isbn = ?";
		int stock = (int) getSession().createQuery(hql2).setString(0, isbn).uniqueResult();
		if(stock == 0) {
			throw new BookStockException("库存不足");
		}
		String hql = "update Book b set b.stock = b.stock - 1 where b.isbn = ?";
		getSession().createQuery(hql).setString(0, isbn).executeUpdate();
	}

	@Override
	public void updateUserAccount(String username, int price) {
		String hql2 = "select a.balance from Account a where a.username = ?";
		int balance = (int) getSession().createQuery(hql2).setString(0, username).uniqueResult();
		if(balance < price) {
			throw new UserAccountException("余额不足");
		}
		String hql = "update Account a set a.balance = a.balance - ? where a.username = ?";
		getSession().createQuery(hql).setInteger(0, price).setString(1, username).executeUpdate();
	}
	
}
