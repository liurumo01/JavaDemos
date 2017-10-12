package space.snowwolf.struts2.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DAO {
	private static Map<Integer, Employee> emps = new LinkedHashMap<Integer, Employee>();
	
	static {
		emps.put(1301, new Employee(1301, "常子欣", "czx@snowwolf.space"));
		emps.put(1302, new Employee(1302, "沈诗瑶", "ssy@snowwolf.space"));
		emps.put(1303, new Employee(1303, "宇文杉月", "ywsy@snowwolf.space"));
		emps.put(1304, new Employee(1304, "欧阳明远", "oymy@snowwolf.space"));
		emps.put(1305, new Employee(1305, "夏若帆", "xrf@snowwolf.space"));
	}
	
	public List<Employee> getEmployees() {
		System.out.println(emps.values());
		return new ArrayList<>(emps.values());
	}
	
	public void delete(Integer id) {
		emps.remove(id);
	}
	
	public void add(Employee emp) {
		emp.setId((int)System.currentTimeMillis());
		emps.put(emp.getId(), emp);
	}
	
	public Employee get(Integer id) {
		return emps.get(id);
	}
	
	public void update(Employee emp) {
		emps.put(emp.getId(), emp);
	}
}
