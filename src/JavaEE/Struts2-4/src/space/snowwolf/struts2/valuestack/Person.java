package space.snowwolf.struts2.valuestack;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;
	private List<Product> products = new ArrayList<Product>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String execute() {
		products.add(new Product("CPU", "Intel", 1200));
		products.add(new Product("Screen", "AOC", 900));
		products.add(new Product("RAM", "Kingston", 450));
		return "success";
	}
	
}
