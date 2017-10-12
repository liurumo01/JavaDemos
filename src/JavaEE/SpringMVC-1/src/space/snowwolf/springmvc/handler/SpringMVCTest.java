package space.snowwolf.springmvc.handler;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import space.snowwolf.springmvc.entity.User;

@SessionAttributes(value={"user"}, types={String.class})
@Controller
@RequestMapping("/springmvc")
public class SpringMVCTest {

	private static final String SUCCESS = "success";
	
	@RequestMapping("/testRedirect")
	private String testRedirect() {
		System.out.println("test redirect");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/testView")
	public String testView() {
		System.out.println("hello view");
		return "helloView";
	}
	
	@RequestMapping("/testViewAndViewResolver")
	private String testViewAndViewResolver() {
		System.out.println("test view and view resolver");
		return SUCCESS;
	}
	
	@ModelAttribute
	private void getUser(@RequestParam(value="id", required=false) Integer id, Map<String, Object> map) {
		System.out.println("model attribute");
		if(id != null) {
			User user = new User(1,"Tom", "123456", 12, "tom@163.com");
			System.out.println("从数据库中获取一个对象:" + user);
			map.put("user", user);
		}
	}
	
	@RequestMapping("/testModelAttribute")
	private String testModelAttribute(User user) {
		System.out.println("test model attribute:" + user);
		return SUCCESS;
	}
	
	@RequestMapping("/testSessionAttributes")
	private String testSessionAttributes(Map<String, Object> map) {
		User user = new User("Tom", "123456", 15, "tom@163.com");
		map.put("user", user);
		map.put("school", "atguigu");
		return SUCCESS;
	}
	
	@RequestMapping("/testMap")
	private String testMap(Map<String, Object> map) {
		System.out.println(map.getClass().getName());
		map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
		return SUCCESS;
	}
	
	@RequestMapping("/testModelAndView")
	private ModelAndView testModelAndView() {
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}
	
	@RequestMapping("/testServletAPI")
	private String testSetvletAPI(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("test servlet API:" + request + ", " + response);
		return SUCCESS;
	}
	
	@RequestMapping("/testPojo")
	private String testPojo(User user) {
		System.out.println("test pojo:" + user);
		return SUCCESS;
	}
	
	@RequestMapping("/testCookieValue")
	private String testCookieValue(@CookieValue(value="JSESSIONID", required=false) String cookie) {
		System.out.println("test cookie value:" + cookie);
		return SUCCESS;
	}
	
	@RequestMapping("/testRequestHeader")
	private String testRequestHeader(@RequestHeader(value="Accept-Language") String al) {
		System.out.println("test request header, Accept-Language=" + al);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="name", required=false) String name, @RequestParam(value="age", required=false, defaultValue="0") int age) {
		System.out.println("test request param: name=" + name + ", age=" + age);
		return SUCCESS;
	}
	
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("test request mapping");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testMethod", method=RequestMethod.POST)
	private String testMethod() {
		System.out.println("test method");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testParamsAndHeaders", params={"username", "age!=10"}, headers={"host=localhost:8080"})
	private String testParamsAndHeaders() {
		System.out.println("test params and handlers");
		return SUCCESS;
	}
	
	@RequestMapping("/testAntPath/*/abc")
	private String testAntPath() {
		System.out.println("test ant path");
		return SUCCESS;
	}
	
	@RequestMapping("/testPathVariable/{id}")
	private String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("test path variable, id = " + id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.GET)
	private String testRestGet(@PathVariable("id") Integer id) {
		System.out.println("test rest get:" + id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest", method=RequestMethod.POST)
	private String testRestPost() {
		System.out.println("test rest post");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.DELETE)
	private String testRestDelete(@PathVariable("id") Integer id) {
		System.out.println("test rest delete:" + id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.PUT)
	private String testRestPut(@PathVariable("id") Integer id) {
		System.out.println("test rest put:" + id);
		return SUCCESS;
	}
}
