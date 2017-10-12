package space.snowwolf.jpa.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import space.snowwolf.jpa.spring.entities.Person;

@Repository
public class PersonDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Person person) {
		entityManager.persist(person);
	}
	
}
