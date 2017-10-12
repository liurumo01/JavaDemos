package space.snowwolf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = 4933357751069714015L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		Cookie cookie = new Cookie("user",username);
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		request.getSession().setAttribute("user", username);
		response.sendRedirect("main.jsp");
	}
}
