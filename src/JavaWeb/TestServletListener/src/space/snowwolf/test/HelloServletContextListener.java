package space.snowwolf.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext���󱻴���" + arg0.getServletContext());
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext��������" + arg0.getServletContext());
	}

}
