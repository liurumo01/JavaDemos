package space.snowwolf.struts2.validation.app;


import java.math.BigInteger;
import java.util.Scanner;

import com.opensymphony.xwork2.ActionSupport;

public class TestValidationAction extends ActionSupport {

	private static final long serialVersionUID = 7736740905886792414L;
	
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("age : " + age);
		return "success";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = null;
		while(sc.hasNextLine()) {
			a = new BigInteger(sc.nextLine(), 16);
			System.out.println(a);
		}
		sc.close();
	}
}
