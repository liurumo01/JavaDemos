package space.snowwolf.struts2.app2.model;

import java.util.Date;

public class Customer {
	
	private int age;
	private Date birth;
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Customer [age=" + age + ", birth=" + birth + "]";
	}
}
