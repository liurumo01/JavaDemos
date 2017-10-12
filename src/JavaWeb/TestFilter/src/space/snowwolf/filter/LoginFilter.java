package space.snowwolf.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends HttpFilter {
	
	private String userSessionKey;
	private String redirectPage;
	private String[] uncheckedUrls;
	
	@Override
	protected void init() {
		FilterConfig config = getFilterConfig();
		userSessionKey = config.getServletContext().getInitParameter("userSessionKey");
		redirectPage = config.getInitParameter("redirectPage");
		uncheckedUrls = config.getInitParameter("uncheckedUrls").split(",");
	}
	
	public String getUserSessionKey() {
		return userSessionKey;
	}

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String servletPath = request.getServletPath();
		
		if(Arrays.asList(uncheckedUrls).contains(servletPath)) {
			chain.doFilter(request, response);
			return;
		}
		
		Object obj = request.getSession().getAttribute(userSessionKey);
		if(obj == null) {
			response.sendRedirect(request.getContextPath() + redirectPage);
			return;
		}
		chain.doFilter(request, response);
	}

}
