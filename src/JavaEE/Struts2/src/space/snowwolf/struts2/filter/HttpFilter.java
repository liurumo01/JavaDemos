package space.snowwolf.struts2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 封装了过滤器的基本操作
 */
public abstract class HttpFilter implements Filter {
	
	protected FilterConfig config;
	
	/**
	 * 获取 FilterConfig 对象和执行初始化操作，子类继承本类应重写init()方法而非本方法
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		init();
	}
	
	/**
	 * 执行初始化操作
	 */
	protected void init() {
		
	}
	
	/**
	 * 将 Filter 类的 ServletResquest 对象和 ServletResponse 对象转换成
	 * HttpServletRequest和HttpServletResponse对象
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		doFilter(req, res, chain);
	}
	
	/**
	 * 定义抽象方法，子类需实现此方法以完成过滤器需要执行的操作
	 */
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException;
	
	/**
	 * 定义销毁 Filter 对象时应执行的操作
	 */
	@Override
	public void destroy() {
		
	}
	
}
