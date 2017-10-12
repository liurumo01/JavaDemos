package space.snowwolf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessStep2Controller extends HttpServlet {
	private static final long serialVersionUID = -5709917336164432795L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String type = request.getParameter("type");
		String card = request.getParameter("card");
		
		Customer customer = new Customer(name,address,type,card);
		request.getSession().setAttribute("customer", customer);
		
		response.sendRedirect(request.getContextPath() + "/shoppingcart/confirm.jsp");
	}
}
