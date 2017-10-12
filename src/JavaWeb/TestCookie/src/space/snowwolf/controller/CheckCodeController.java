package space.snowwolf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeController extends HttpServlet {
	private static final long serialVersionUID = 7404799208454708868L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("CHECK_CODE_PARAM_NAME");
		String value = (String) request.getSession().getAttribute("CHECK_CODE_KEY");
		
		System.out.println(code);
		System.out.println(value);
		
		if(!(code != null && code.equals(value))) {
			request.getSession().setAttribute("message", "验证码不正确");
			response.sendRedirect(request.getContextPath() + "/check/index.jsp");
			return;
		}
		
		System.out.println("受理请求");
	}

}
