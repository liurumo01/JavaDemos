package space.snowwolf.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloSimpleTag implements SimpleTag {
	private PageContext pc;
	private String value;
	private String count;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//System.out.println(value);
		//System.out.println(count);
		JspWriter out = pc.getOut();
		out.write("<h1>");
		for(int i=0;i<Integer.valueOf(count);i++) {
			out.print(i + ":" + value + "<br/>");
		}
		out.write("</h1>");
		//pc.getOut().write("<h1>Hello," + pc.getRequest().getParameter("name") + "</h1>");
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub
		System.out.println("setJspBody");
	}

	@Override
	public void setJspContext(JspContext pc) {
		this.pc = (PageContext) pc;
	}

	@Override
	public void setParent(JspTag parent) {
		// TODO Auto-generated method stub
		System.out.println("setParent");
	}
}
