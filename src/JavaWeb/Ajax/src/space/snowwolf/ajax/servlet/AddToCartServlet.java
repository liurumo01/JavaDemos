package space.snowwolf.ajax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import space.snowwolf.ajax.beans.ShoppingCart;

public class AddToCartServlet extends HttpServlet {

	private static final long serialVersionUID = 2427780317010112654L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("id");
		int price = Integer.valueOf(request.getParameter("price"));
		
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if(cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		
		cart.addToCart(bookName, price);
		StringBuilder builder = new StringBuilder();
		builder.append("{").append("\"bookName\":\"" + bookName + "\"").append(",")
			.append("\"totalBookNumber\":" + cart.getTotalBookNumber()).append(",")
			.append("\"totalMoney\":" + cart.getTotalMoney()).append("}");
		
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(cart);
		System.out.println(str);
		
		response.setContentType("text/javascript");
		response.getWriter().write(str);
	}

}
