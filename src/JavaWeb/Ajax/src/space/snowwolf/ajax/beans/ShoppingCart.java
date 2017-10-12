package space.snowwolf.ajax.beans;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart {
	
	//private int totalBookNumber;
	private Map<String,ShoppingCartItem> items = new HashMap<String,ShoppingCartItem>();
	private String bookName;
	
	public String getBookName() {
		return bookName;
	}
	
	public void addToCart(String bookName,int price) {
		
		this.bookName = bookName;
		
		if(items.containsKey(bookName)) {
			ShoppingCartItem item = items.get(bookName);
			item.setNumber(item.getNumber() + 1);
		}
		else {
			ShoppingCartItem item = new ShoppingCartItem();
			item.setBookName(bookName);
			item.setPrice(price);
			item.setNumber(1);
			items.put(bookName,item);
		}
	}
	
	public int getTotalBookNumber() {
		int total = 0;
		
		Iterator<Entry<String, ShoppingCartItem>> it = items.entrySet().iterator();
		while(it.hasNext()) {
			total += it.next().getValue().getNumber();
		}
		
		return total;
	}
	
	public int getTotalMoney() {
		int money = 0;
		
		Iterator<Entry<String, ShoppingCartItem>> it = items.entrySet().iterator();
		while(it.hasNext()) {
			ShoppingCartItem item = it.next().getValue();
			money += item.getPrice() * item.getNumber();
		}
		
		return money;
	}
}
