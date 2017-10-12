package space.snowwolf.springmvc.handler;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import space.snowwolf.springmvc.dao.DepartmentDAO;
import space.snowwolf.springmvc.dao.EmployeeDAO;
import space.snowwolf.springmvc.entity.Employee;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private DepartmentDAO departmentDAO;

	@RequestMapping("/emps")
	public String list(Map<String, Object> map) {
		map.put("employees", employeeDAO.getAll());
		return "list";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("departments", departmentDAO.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String save(@Valid Employee employee, BindingResult result, Map<String, Object> map) {
		System.out.println("save:" + employee);
		
		if(result.getErrorCount() > 0) {
			System.out.println("Error!");
			for(FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			map.put("departments", departmentDAO.getDepartments());
			return "input";
		}
		
		employeeDAO.save(employee);
		return "redirect:/emps";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		employeeDAO.delete(id);
		return "redirect:/emps";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String input(@PathVariable Integer id, Map<String, Object> map) {
		map.put("employee", employeeDAO.get(id));
		map.put("departments", departmentDAO.getDepartments());
		return "input";
	}

	@ModelAttribute
	public void getEmployee(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
		if(id != null) {
			map.put("employee", employeeDAO.get(id));
		}
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.PUT)
	public String update(Employee employee) {
		employeeDAO.save(employee);
		return "redirect:/emps";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setDisallowedFields("name");
	}
}
