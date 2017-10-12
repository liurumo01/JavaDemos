package space.snowwolf.spring.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JdbcTest {
	
	private ApplicationContext context = null;
	private JdbcTemplate jdbcTemplate = null;
	private EmployeeDAO employeeDAO = null;
	private DepartmentDAO departmentDAO = null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;;
	
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		employeeDAO = context.getBean(EmployeeDAO.class);
		departmentDAO = context.getBean(DepartmentDAO.class);
		namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
	}

	@Test
	public void testDataSource() {
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		System.out.println(dataSource);
	}
	
	@Test
	public void testUpdate() {
		String sql = "update employee set name = ? where id = ?";
		jdbcTemplate.update(sql, "Jack", 5);
	}
	
	@Test
	public void testBatchUpdate() {
		String sql = "insert into employee(name, email, department_id) values (?, ?, ?)";
		List<Object[]> args = new ArrayList<Object[]>();
		args.add(new Object[]{"AA", "aa@qq.com", 1});
		args.add(new Object[]{"BB", "aa@qq.com", 1});
		args.add(new Object[]{"CC", "aa@qq.com", 2});
		args.add(new Object[]{"DD", "aa@qq.com", 3});
		args.add(new Object[]{"EE", "aa@qq.com", 4});
		jdbcTemplate.batchUpdate(sql, args);
	}
	
	@Test
	public void testQueryForObject() {
		String sql = "select * from employee where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee);
	}

	@Test
	public void testQueryForList() {
		String sql = "select * from employee where id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 5);
		System.out.println(employees);
	}
	
	@Test
	public void testQuertForValue() {
		String sql = "select count(id) from employee";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	@Test
	public void testEmployeeDAO() {
		System.out.println(employeeDAO.get(2));
	}
	
	@Test
	public void testDepartmentDAO() {
		System.out.println(departmentDAO.get(3));
	}
	
	@Test
	public void testNamedPremeterJdbcTemplate() {
		String sql = "insert into employee (name, email, department_id) values (:name, :email, :department_id)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", "FF");
		paramMap.put("email", "ff@126.com");
		paramMap.put("department_id", "4");
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	@Test
	public void testNamedPremeterJdbcTemplate2() {
		String sql = "insert into employee (name, email, department_id) values (:name, :email, :departmentId)";
		Employee employee = new Employee();
		employee.setName("XYZ");
		employee.setEmail("xyz@sina.com");
		employee.setDepartmentId(2);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}
}
