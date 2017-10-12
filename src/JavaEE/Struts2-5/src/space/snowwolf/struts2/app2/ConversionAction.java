package space.snowwolf.struts2.app2;

import space.snowwolf.struts2.app2.model.Customer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ConversionAction extends ActionSupport implements ModelDriven<Customer> {

	private static final long serialVersionUID = -327159183616910278L;
	
	private Customer model;
	
	public String execute() {
		System.out.println(model);
		return "success";
	}

	@Override
	public Customer getModel() {
		model = new Customer();
		return model;
	}
}
