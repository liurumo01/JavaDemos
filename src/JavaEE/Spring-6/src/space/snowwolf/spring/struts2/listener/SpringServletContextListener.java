package space.snowwolf.spring.struts2.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class SpringServletContextListener implements ServletContextListener {

	public SpringServletContextListener() {
		// TODO Auto-generated constructor stub
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		String config = servletContext.getInitParameter("configLocation");
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		servletContext.setAttribute("ApplicationContext", context);
	}

}
