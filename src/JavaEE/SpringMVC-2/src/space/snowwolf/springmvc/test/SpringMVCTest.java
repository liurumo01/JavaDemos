package space.snowwolf.springmvc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import space.snowwolf.springmvc.dao.EmployeeDAO;
import space.snowwolf.springmvc.entity.Employee;
import space.snowwolf.springmvc.exception.UsernameNotMatchPasswordException;

@Controller
public class SpringMVCTest {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping("/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("i") int i) {
		String[] vals = new String[10];
		System.out.println(vals[i]);
		return "success";
	}
	
	@RequestMapping(value="/testDefaultHandlerExceptionResolver", method=RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver() {
		System.out.println("testDefaultHandlerExceptionResolver");
		return "success";
	}
	
	//@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="测试")
	@RequestMapping("/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") int i) {
		if(i == 13) {
			throw new UsernameNotMatchPasswordException();
		}
		System.out.println("正常执行");
		return "success";
	}
	
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView handleArithmeticException2(Exception ex) {
//		System.out.println("[异常]:" + ex);
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("exception", ex);
//		return mv;
//	}
	
//	@ExceptionHandler({ArithmeticException.class})
//	public ModelAndView handleArithmeticException(Exception ex) {
//		System.out.println("异常:" + ex);
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("exception", ex);
//		return mv;
//	}

	@RequestMapping("/testExceptionHandlerExceptionResolver")
	public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i) {
		System.out.println("result:" + (10 / i));
		return "success";
	}

	@RequestMapping("/testConversionServiceConverter")
	public String testConverter(@RequestParam("employee") Employee employee) {
		System.out.println("save:" + employee);
		employeeDAO.save(employee);
		return "redirect:/emps";
	}

	@RequestMapping("/testJSON")
	@ResponseBody
	public Collection<Employee> testJSON() {
		return employeeDAO.getAll();
	}

	@RequestMapping("/testHttpMessageConverter")
	@ResponseBody
	public String testHttpMessageConverter(@RequestBody String body) {
		System.out.println(body);
		return "Hello world!" + new Date();
	}

	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
		byte[] body = null;
		ServletContext context = session.getServletContext();
		InputStream in = context.getResourceAsStream("/files/index.txt");
		body = new byte[in.available()];
		in.read(body);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");

		HttpStatus statusCode = HttpStatus.OK;

		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}

	@Autowired
	private ResourceBundleMessageSource messageSource;

	@RequestMapping("/i18n")
	public String testI18N(Locale locale) {
		String val = messageSource.getMessage("i18n.user", null, locale);
		System.out.println(val);
		return "i18n";
	}

	@RequestMapping("/i18n2")
	public String testI18N2(Locale locale) {
		return "i18n2";
	}

	@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("filename:" + file.getOriginalFilename());
		System.out.println("desc:" + description);
		System.out.println("input stream:" + file.getInputStream());
		return "success";
	}
}
