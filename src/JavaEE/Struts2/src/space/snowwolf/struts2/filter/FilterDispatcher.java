package space.snowwolf.struts2.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.snowwolf.struts2.model.Product;

@WebFilter("*.action")
public class FilterDispatcher extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		
		String path = null;
		if(servletPath.equals("/product-input.action")) {
			path = "/WEB-INF/pages/input.jsp";
		}
		if(servletPath.equals("/product-save.action")) {
			String productName = request.getParameter("productName");
			String productDesc = request.getParameter("productDesc");
			double productPrice = Double.parseDouble(request.getParameter("productPrice"));
			Product product = new Product(null,productName,productDesc,productPrice);
			
			System.out.println("Save Procuct : " + product);
			product.setId(1);
			request.setAttribute("product", product);
			
			path = "/WEB-INF/pages/details.jsp";
		}
		if(path != null) {
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

}
