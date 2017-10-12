package space.snowwolf.struts2.model;

public class Product {
	private Integer id;
	private String name;
	private String desc;
	private double price;
	
	public Product() {}
	public Product(Integer id,String name,String desc,Double price) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc
				+ ", price=" + price + "]";
	}
}
