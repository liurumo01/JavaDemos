package space.snowwolf.controller;

public class Customer {
	private String name;
	private String address;
	private String type;
	private String card;
	
	public Customer() {
		
	}
	public Customer(String name, String address, String type, String card) {
		super();
		this.name = name;
		this.address = address;
		this.type = type;
		this.card = card;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
}
