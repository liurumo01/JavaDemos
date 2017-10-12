package space.snowwolf.struts2.action;

import space.snowwolf.struts2.model.Department;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestComplextAction extends ActionSupport implements ModelDriven<Department> {
	
	private static final long serialVersionUID = -8182502484621308309L;
	
	private Department department;

	@Override
	public Department getModel() {
		department = new Department();
		return department;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(department);
		return super.execute();
	}
}
