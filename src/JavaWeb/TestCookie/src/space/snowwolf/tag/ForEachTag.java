package space.snowwolf.tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag<E> extends SimpleTagSupport {
	private Collection<E> items;
	private String var;
	
	public void setItems(Collection<E> items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		for(E obj : items) {
			pageContext.setAttribute(var, obj);
			getJspBody().invoke(null);
		}
	}
}
