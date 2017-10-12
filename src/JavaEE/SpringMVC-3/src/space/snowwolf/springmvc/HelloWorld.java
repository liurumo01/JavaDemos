package space.snowwolf.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	
	@Autowired(required=false)
	private UserService userService;
	
	public HelloWorld() {
		System.out.println("HelloWorld's Constructor...");
	}
	
	@RequestMapping("/helloWorld")
	public String hello() {
		System.out.println("success");
		System.out.println(userService);
		return "success";
	}
}
