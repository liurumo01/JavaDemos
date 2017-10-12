package space.snowwolf.struts2.ex;

import java.util.ArrayList;
import java.util.List;

public class DAO {
	public List<Department> getDepartment() {
		List<Department> departments = new ArrayList<Department>();
		departments.add(new Department(1001,"技术部"));
		departments.add(new Department(1002,"财务部"));
		departments.add(new Department(1003,"市场部"));
		departments.add(new Department(1004,"宣传部"));
		return departments;
	}
	public List<Role> getRole() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role(1,"经理"));
		roles.add(new Role(2,"主任"));
		roles.add(new Role(3,"员工"));
		roles.add(new Role(4,"检验"));
		return roles;
	}
}
