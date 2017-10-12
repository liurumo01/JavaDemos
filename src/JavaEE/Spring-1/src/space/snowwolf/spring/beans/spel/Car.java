package space.snowwolf.spring.beans.spel;

public class Car {
	private String brand;
	private double price;
	private double tyrePremeter;
	
	public Car() {
		System.out.println("Car's Constructor...");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTyrePremeter() {
		return tyrePremeter;
	}

	public void setTyrePremeter(double tyrePremeter) {
		this.tyrePremeter = tyrePremeter;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", tyrePremeter=" + tyrePremeter + "]";
	}
}
