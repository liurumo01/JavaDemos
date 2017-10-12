package space.snowwolf.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

@SuppressWarnings("unused")
public class TestAwareAction implements ApplicationAware,SessionAware,RequestAware,ParameterAware {
	
	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	
	public String execute() {
		
		application.put("applicationKey2", "applicationValue2");
		System.out.println(application.get("date"));
		
		return "success";
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
