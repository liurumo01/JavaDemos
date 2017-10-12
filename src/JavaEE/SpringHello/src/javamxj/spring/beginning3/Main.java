package javamxj.spring.beginning3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main
{
	public static void main(String[] args)
	{
		HelloBean helloBean = new HelloBean();
		System.out.println(helloBean.getHelloWorld());
		
		Resource res = new ClassPathResource("javamxj/spring/beginning3/bean.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		
		helloBean = (HelloBean)factory.getBean("helloBean");
		System.out.println(helloBean.getHelloWorld());
	}
}
