package space.snowwolf.struts2.app2.converters;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {
	
	private DateFormat dateFormat;
	
	public DateConverter() {
		System.out.println("DateConverter's Constructor...");
	}
	
	public DateFormat getDateFormat() {
		if(dateFormat == null) {
			ServletContext servletContext = ServletActionContext.getServletContext();
			String pattern = servletContext.getInitParameter("pattern");
			dateFormat = new SimpleDateFormat(pattern);
		}
		return dateFormat;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		System.out.println("Convert From String...");
		System.out.println(toClass);
		
		if(toClass == Date.class) {
			if(values != null && values.length > 0) {
				String value = values[0];
				try {
					return getDateFormat().parseObject(value);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public String convertToString(Map context, Object o) {
		
		System.out.println("Convert To String...");
		
		if(o instanceof Date) {
			Date date = (Date) o;
			return dateFormat.format(date);
		}
		return null;
	}
	
}
