package space.snowwolf.struts2.app;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction implements RequestAware, ModelDriven<Employee>, Preparable {
	
	private DAO dao = new DAO();
	private Map<String, Object> request;
	
	private Employee employee;
	
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void prepareEdit() {
		employee = dao.get(id);
	}
	
	public String edit() {
		return "edit";
	}
	
	public String list() {
		request.put("emps", dao.getEmployees());
		return "list";
	}
	
	public void prepareAdd() {
		employee = new Employee();
	}
	
	public String add() {
		dao.add(employee);
		return "success";
	}
	
	public String delete() {
		dao.delete(id);
		return "success";
	}
	
	public void prepareUpdate() {
		employee = new Employee();
	}
	
	public String update() {
		dao.update(employee);
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public Employee getModel() {
		return employee;
	}

	@Override
	public void prepare() throws Exception {
		System.out.println("prepare...");
	}
}
