package space.snowwolf.spring.struts2.action;

import space.snowwolf.spring.struts2.service.PersonService;

public class PersonAction {
	
	private PersonService personService;
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public String execute() {
		personService.save();
		System.out.println("execute...");
		return "success";
	}
}
