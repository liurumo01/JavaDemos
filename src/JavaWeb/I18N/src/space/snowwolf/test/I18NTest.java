package space.snowwolf.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class I18NTest {

	@Test
	public void test() {
		Locale locale = Locale.US;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
		
		locale = new Locale("zh","CN");
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
	}
	
	@Test
	public void testDataFormat() {
		Locale locale = Locale.US;
		
		Date date = new Date();
		System.out.println(date);
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, locale);
		String str = dateFormat.format(date);
		System.out.println(str);
	}

	@Test
	public void testDataFormat2() throws ParseException {
		String str = "1990-12-12 12:12:12";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = dateFormat.parse(str);
		System.out.println(date);
	}
}
