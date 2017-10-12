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
 * ��װ�˹������Ļ�������
 */
public abstract class HttpFilter implements Filter {
	
	protected FilterConfig config;
	
	/**
	 * ��ȡ FilterConfig �����ִ�г�ʼ������������̳б���Ӧ��дinit()�������Ǳ�����
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		init();
	}
	
	/**
	 * ִ�г�ʼ������
	 */
	protected void init() {
		
	}
	
	/**
	 * �� Filter ��� ServletResquest ����� ServletResponse ����ת����
	 * HttpServletRequest��HttpServletResponse����
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		doFilter(req, res, chain);
	}
	
	/**
	 * ������󷽷���������ʵ�ִ˷�������ɹ�������Ҫִ�еĲ���
	 */
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException;
	
	/**
	 * �������� Filter ����ʱӦִ�еĲ���
	 */
	@Override
	public void destroy() {
		
	}
	
}
