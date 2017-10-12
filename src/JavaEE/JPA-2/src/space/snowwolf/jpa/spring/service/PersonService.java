package space.snowwolf.jpa.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.snowwolf.jpa.spring.dao.PersonDAO;
import space.snowwolf.jpa.spring.entities.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	@Transactional
	public void savePersons(Person p1, Person p2) {
		personDAO.save(p1);
		personDAO.save(p2);
	}
	
}
