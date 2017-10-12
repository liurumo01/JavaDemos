package space.snowwolf.ajax.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateUsername extends HttpServlet {

	private static final long serialVersionUID = 6791852289944702381L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> usernames = Arrays.asList("AAA","BBB","CCC");
		String username = request.getParameter("username");
		String result = null;
		if(usernames.contains(username)) {
			result = "<font color='red'>该用户名已经被使用</font>";
		} else {
			result = "<font color='green'>该用户名可以使用</font>";
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().write(result);
	}

}
