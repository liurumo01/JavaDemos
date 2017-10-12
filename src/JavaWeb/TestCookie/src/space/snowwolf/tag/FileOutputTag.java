package space.snowwolf.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FileOutputTag extends SimpleTagSupport {
	private String src;

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext) getJspContext();
		JspWriter out = pc.getOut();
		InputStream is = pc.getServletContext().getResourceAsStream(src);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String str = null;
		out.println("<pre>");
		while((str = reader.readLine()) != null) {
			str = Pattern.compile("<").matcher(str).replaceAll("&lt;");
			str = Pattern.compile(">").matcher(str).replaceAll("&gt;");
			out.println(str);
		}
		out.println("</pre>");
		reader.close();
		is.close();
	}
}
