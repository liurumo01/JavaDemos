package space.snowwolf.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MaxTag implements SimpleTag {

	private JspWriter out;
	
	private String num1;
	private String num2;
	
	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Integer n1 = Integer.valueOf(num1);
		Integer n2 = Integer.valueOf(num2);
		
		out.write((n1 > n2 ? n1 : n2).toString());
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setJspContext(JspContext pc) {
		out = pc.getOut();
	}

	@Override
	public void setParent(JspTag parent) {
		// TODO Auto-generated method stub
	}
}
