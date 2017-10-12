package space.snowwolf.struts2.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserLoginAction implements SessionAware,ApplicationAware {
	
	private Map<String,Object> session;
	private Map<String,Object> application;
	private String username;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String login() {
		session.put("user", username);
		Integer count = (Integer) application.get("count");
		if(count == null) {
			count = 0;
		}
		count++;
		session.put("user", username);
		application.put("count", count);
		return "success";
	}
	
	public String logout() {
		Integer count = (Integer) application.get("count");
		if(count != null && count > 0) {
			count--;			
			application.put("count", count);
		}
		((SessionMap<String,Object>)session).invalidate();
		return "success";
	}
}
