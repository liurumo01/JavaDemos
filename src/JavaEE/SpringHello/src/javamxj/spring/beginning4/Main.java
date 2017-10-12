package javamxj.spring.beginning4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main
{
	public static void main(String[] args)
	{
		Resource res = new ClassPathResource("javamxj/spring/beginning4/bean.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		
		HelloBean helloBean = (HelloBean)factory.getBean("helloBean");
		helloBean.sayHello();
	}
}
