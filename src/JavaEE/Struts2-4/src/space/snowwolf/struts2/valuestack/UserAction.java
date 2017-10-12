package space.snowwolf.struts2.valuestack;

import java.util.List;

public class UserAction {
	private String userId;
	private String username;
	private String password;
	private String desc;
	private boolean married;
	private String gender;
	private List<String> cities;
	private String age;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "UserAction [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", desc=" + desc + ", married="
				+ married + ", gender=" + gender + ", cities="
				+ cities + ", age=" + age + "]";
	}
	
	public String save() {
		System.out.println(this);
		return "input";
	}
}
