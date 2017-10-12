import org.tianyuan.po.Employee;
import org.tianyuan.sorm.core.Query;
import org.tianyuan.sorm.core.QueryFactory;

public class Test {
	public static void main(String[] args) {
		select01();
	}
	
	public static void add() {
		Employee e = new Employee();
		e.setAge(18);
		e.setEmpname("ÕÅÈý");
		e.setSalary(2000.0);
		
		Query q = QueryFactory.createQuery();
		q.insert(e);
	}
	
	public static void delete() {
		Employee e = new Employee();
		e.setId(6);
		
		Query q = QueryFactory.createQuery();
		q.delete(e);
	}
	
	public static void update() {
		Employee e = new Employee();
		e.setId(7);
		e.setAge(20);
		
		Query q = QueryFactory.createQuery();
		q.update(e, new String[] {"age"});
	}
	
	public static void select01() {
		Query q = QueryFactory.createQuery();
		Employee e = (Employee)q.queryUniqueRows("select * from employee where id > ?", Employee.class, new Object[] {3});
		
		System.out.println(e.getEmpname());
	}
}
