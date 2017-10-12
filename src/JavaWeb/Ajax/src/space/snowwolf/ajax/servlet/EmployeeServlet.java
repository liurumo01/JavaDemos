package space.snowwolf.ajax.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.snowwolf.ajax.DAO.BaseDAO;
import space.snowwolf.ajax.beans.Department;
import space.snowwolf.ajax.beans.Employee;
import space.snowwolf.ajax.beans.Location;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = -178791011158907384L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		Method method;
		try {
			method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private BaseDAO baseDAO = new BaseDAO();
	
	public void listLocations(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String sql = "select id, city from locations";
		List<Location> locations = baseDAO.queryForList(sql, Location.class);
		request.setAttribute("locations", locations);
		request.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(request, response);
	}
	
	public void listDepartments(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = Integer.valueOf(request.getParameter("locationId"));
		String sql = "select id, name from departments where location_id = ?";
		List<Department> departments = baseDAO.queryForList(sql, Department.class, id);
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(departments);
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(str);
	}
	
	public void listEmployees(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = Integer.valueOf(request.getParameter("departmentId"));
		String sql = "select id, last_name as lastName, salary from employees where department_id = ?";
		List<Employee> employees = baseDAO.queryForList(sql, Employee.class, id);
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(employees);
		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(str);
	}
}
