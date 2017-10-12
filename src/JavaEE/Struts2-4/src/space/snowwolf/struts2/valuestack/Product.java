package space.snowwolf.struts2.valuestack;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class Product implements RequestAware, SessionAware {
	private String name;
	private String desc;
	private double price;

	private Map<String, Object> request;
	private Map<String, Object> session;
	
	public Product() {}
	public Product(String name, String desc, double price) {
		this.name = name;
		this.desc = desc;
		this.price = price;
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

	public String save() {
		System.out.println("Procuct Save + " + this);

		ValueStack stack = ActionContext.getContext().getValueStack();

		Test obj = new Test();
		obj.setDesc("AABBCCDD");
		obj.setName("ABCD");
		stack.push(obj);

		session.put("product", this);
		request.put("test", obj);

		@SuppressWarnings("unused")
		int i = 10 / 0;

		return "success";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", desc=" + desc + ", price=" + price
				+ "]";
	}

	public String testTag() {
		name = "CPU";
		desc = "Intel";
		price = 1200;
		return "success";
	}
}
