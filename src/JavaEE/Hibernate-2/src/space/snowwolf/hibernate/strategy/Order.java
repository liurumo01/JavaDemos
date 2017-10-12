package space.snowwolf.hibernate.strategy;

public class Order {

	private Integer orderId;
	private String orderName;
	private Customer customer;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Order && orderId == ((Order)obj).orderId;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
	}
}
