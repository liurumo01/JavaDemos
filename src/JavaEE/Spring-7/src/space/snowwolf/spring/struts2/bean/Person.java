package space.snowwolf.spring.struts2.bean;

public class Person {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void hello() {
		System.out.println("My name is " + username);
	}
}
