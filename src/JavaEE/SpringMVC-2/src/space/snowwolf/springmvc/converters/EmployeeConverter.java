package space.snowwolf.springmvc.converters;

import org.springframework.core.convert.converter.Converter;

import space.snowwolf.springmvc.entity.Department;
import space.snowwolf.springmvc.entity.Employee;

public class EmployeeConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String arg0) {
		if(arg0 != null) {
			String[] vals = arg0.split("-");
			if(vals != null && vals.length == 4) {
				String name = vals[0];
				String email = vals[1];
				Integer gender = Integer.parseInt(vals[2]);
				Department department = new Department();
				department.setId(Integer.parseInt(vals[3]));
				
				Employee employee = new Employee(null, name, email, gender, department);
				System.out.println(arg0 + "----" + employee);
				return employee;
			}
		}
		return null;
	}

}
