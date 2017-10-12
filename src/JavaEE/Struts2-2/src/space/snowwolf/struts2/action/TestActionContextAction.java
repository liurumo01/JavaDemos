package space.snowwolf.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {
	public String execute() {
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> applicationMap = actionContext.getApplication();
		applicationMap.put("applicationKey","applicationValue");
		System.out.println(applicationMap.get("date"));
		
		Map<String,Object> sessionMap = actionContext.getSession();
		sessionMap.put("sessionKey","sessionValue");
		
		@SuppressWarnings("unchecked")
		Map<String,Object> requestMap = (Map<String, Object>) actionContext.get("request");
		requestMap.put("requestKey", "requestValue");
		
		Map<String,Object> paramters = actionContext.getParameters();
		System.out.println(((String[])paramters.get("name"))[0]);
		
		return "success";
	}
}
