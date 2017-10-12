package space.snowwolf.spring.beans.cycle;

public class Car {
	
	private String brand;
	
	public Car() {
		System.out.println("Car's constructor...");
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void init() {
		System.out.println("init...");
	}
	
	public void destory() {
		System.out.println("destory...");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
}
