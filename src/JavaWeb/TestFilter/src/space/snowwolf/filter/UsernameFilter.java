package space.snowwolf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UsernameFilter implements Filter {
	
	private String username;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(!request.getParameter("username").equals(username)) {
			request.setAttribute("message", "�û�������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		username = config.getInitParameter("username");
		System.out.println(username);
	}
}
