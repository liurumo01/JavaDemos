package space.snowwolf.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFragment extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		JspFragment bodyContent = getJspBody();
		
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		
		String content = sw.toString().toUpperCase();
		
		getJspContext().getOut().print(content);
		
		System.out.println(sw.toString());
	}
}
