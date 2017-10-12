package space.snowwolf.struts2.action;

public class UserAction {
	public String add() {
		System.out.println("UserAction - add");
		return "add-success";
	}
	
	public String delete() {
		System.out.println("UserAction - delete");
		return "delete-success";
	}
	
	public String update() {
		System.out.println("UserAction - update");
		return "update-success";
	}
	
	public String query() {
		System.out.println("UserAction - query");
		return "query-success";
	}
	
	public String test() {
		System.out.println("UserAction - test");
		return "test-success";
	}
}
