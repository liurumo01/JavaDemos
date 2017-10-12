package space.snowwolf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessStep1Controller extends HttpServlet {
	private static final long serialVersionUID = -3973410885066053122L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String[] books = request.getParameterValues("book");
		request.getSession().setAttribute("books", books);
		response.sendRedirect(request.getContextPath() + "/shoppingcart/step2.jsp");
	}
}
