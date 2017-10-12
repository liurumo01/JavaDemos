package javamxj.spring.beanfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

public class Test
{
	public static void main(String[] args)
	{
		//直接调用HelloBean
		BeanFile bf = new BeanFile();
		System.out.println(bf.getBeanFile());
		
		/**
		 * 利用XmlBeanFactory(Resource resource)
		 * Resource包括:
		 * 1.AbstractResource
		 * 2.ClassPathResource
		 * 3.FileSystemResource
		 * 4.InputStreamResource
		 * 5.ServerletContextResource
		 * 6.UrlResource
		 */
		
		//InputStreamResource(InputStream inputStream)
		InputStream is = null;
		try
		{
			is = new FileInputStream("bean1.xml");
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		Resource resource = new InputStreamResource(is);
		//sayHello(resource);
		
		//ClassPathResource(String path)
		resource = new ClassPathResource("bean2.xml");
		sayHello(resource);
		
		//FileSystemResource(String path)
		resource = new FileSystemResource("bean3.xml");
		sayHello(resource);
		
		//Properties
		BeanDefinitionRegistry reg = new DefaultListableBeanFactory();
		PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(reg);
		reader.loadBeanDefinitions(new ClassPathResource("bean.properties"));
		BeanFactory factory = (BeanFactory) reg;
		bf = (BeanFile) factory.getBean("beanFile");
		System.out.println("利用" + bf.getBeanFile() + "加载Bean.Properties");
		
		//ApplicationContext
		ApplicationContext appContext = new ClassPathXmlApplicationContext("bean4.xml");
		bf = (BeanFile) appContext.getBean("beanFile");
		System.out.println("利用" + bf.getBeanFile() + "加载Bean.xml");
	}
	
	public static void sayHello(Resource resource)
	{
		BeanFactory factory = new XmlBeanFactory(resource);
		BeanFile bf = (BeanFile)factory.getBean("beanFile");
		System.out.println("利用" + bf.getBeanFile() + "加载Bean.xml");
	}
}
