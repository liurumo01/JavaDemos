package space.snowwolf.spring.tx.xml;

public interface BookShopDAO {
	public int findBookPriceByIsbn(String isbn);
	public void updateBookStock(String isbn);
	public void updateUserAccount(String username, int price);
}
