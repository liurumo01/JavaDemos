package space.snowwolf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenController extends HttpServlet {
	private static final long serialVersionUID = 4811619017421250917L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*HttpSession session = request.getSession();
		Object token = session.getAttribute("token");
		String value = request.getParameter("token");
		System.out.println(token);
		System.out.println(value);
		if(token != null && token.equals(value)) {			
			session.removeAttribute("token");
		} else {
			response.sendRedirect(request.getContextPath() + "/submit/token.jsp");
			return;
		}*/
		
		boolean valid = TokenProcessor.getInstance().isTokenValid(request);
		if(valid) {
			TokenProcessor.getInstance().resetToken(request);
		} else {
			response.sendRedirect(request.getContextPath() + "/submit/token.jsp");
			return;
		}
	 	
		String name = request.getParameter("name");
		System.out.println("name: " + name);
		
		response.sendRedirect(request.getContextPath() + "/submit/success.jsp");
	}
}
