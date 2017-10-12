package space.snowwolf.struts2.ex;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class Employee implements SessionAware {
	
	private static Integer count = 0;
	private Map<String, Object> session;
	
	private Integer id;
	private String name;
	private String password;
	private boolean gender;
	private Integer department;
	private Integer role;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password="
				+ password + ", gender=" + gender + ", department="
				+ department + ", role=" + role + ", description="
				+ description + "]";
	}
	
	public String input() {
		return "input";
	}
	
	public String details() {
		id = ++count;
		System.out.println(this);
		session.put("employee", this);
		return "details";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
