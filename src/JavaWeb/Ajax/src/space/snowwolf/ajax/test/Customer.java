package space.snowwolf.ajax.test;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Customer {
	
	private String name;
	private String id;
	
	public Customer(String name,String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCity() {
		return "Beijing";
	}
	
	@JsonIgnore
	public String getBirth() {
		return "1990-12-12";
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Customer customer = new Customer("atguigu", "001");
		String str = mapper.writeValueAsString(customer);
		System.out.println(str);
		
		List<Customer> customers = Arrays.asList(customer,new Customer("BCD","2002-1-1"));
		str = mapper.writeValueAsString(customers);
		System.out.println(str);
	}
}
