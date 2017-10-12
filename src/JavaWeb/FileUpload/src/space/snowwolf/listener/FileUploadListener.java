package space.snowwolf.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import space.snowwolf.utils.FileUploadProperties;

public class FileUploadListener implements ServletContextListener  {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		InputStream in = getClass().getClassLoader().getResourceAsStream("upload.properties");
		
		Properties properties = new Properties();
		try {
			properties.load(in);
			Iterator<Entry<Object,Object>> it = properties.entrySet().iterator();
			while(it.hasNext()) {
				Entry<Object,Object> entry = it.next();
				String name = (String) entry.getKey();
				String value = (String) entry.getValue();
				
				System.out.println(name + "  " + value);
				
				FileUploadProperties.getInstance().addPropertie(name, value);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
