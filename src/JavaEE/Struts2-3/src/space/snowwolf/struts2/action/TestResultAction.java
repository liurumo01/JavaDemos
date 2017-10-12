package space.snowwolf.struts2.action;

public class TestResultAction {
	
	private int number;
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String execute() {
		String result = null;
		if(number % 4 == 0) {
			result = "success";
		} else if(number % 4 == 1) {
			result = "login";
		} else if(number % 4 == 2) {
			result = "index";
		} else {
			result = "test";
		}
		return result;
	}
	
}
