package space.snowwolf.struts2.model;

public class Department {
	
	private Integer id;
	private String name;
	private Manager manager;
	
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
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager="
				+ manager + "]";
	}
}
