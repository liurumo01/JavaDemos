package space.snowwolf.springdata.test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import space.snowwolf.springdata.Person;
import space.snowwolf.springdata.PersonRepository;
import space.snowwolf.springdata.PersonService;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SpringDataTest {
	
	private ApplicationContext context;
	private PersonRepository personRepository;
	private PersonService personService;
	
	{
		context = new ClassPathXmlApplicationContext("spring.xml");
		personRepository = context.getBean(PersonRepository.class);
		personService = context.getBean(PersonService.class);
	}
	
	@Test
	public void testCustomRepositoryMethod() {
		personRepository.test();
	}
	
	@Test
	public void testJpaSpecificationExecutor() {
		int pageNo = 3 - 1;
		int pageSize = 5;
		Pageable pageable = new PageRequest(pageNo, pageSize);
		Specification<Person> specification = new Specification<Person>() {
			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Path path = root.get("id");
				Predicate predicate = cb.gt(path, 5);
				return predicate;
			}
		};
		Page<Person> page = personRepository.findAll(specification, pageable);
		System.out.println("总记录数：" + page.getTotalElements());
		System.out.println("当前第几页：" + (page.getNumber() + 1));
		System.out.println("总页数：" + page.getTotalPages());
		System.out.println("当前页面的List：" + page.getContent());
		System.out.println("当前页面的记录数：" + page.getNumberOfElements());
	}
	
	@Test
	public void testJpaRepository() {
		Person person = new Person();
		person.setBirth(new Date());
		person.setEmail("xyz@163.com");
		person.setName("xyz");
		person.setId(28);
		
		Person person2 = personRepository.saveAndFlush(person);
		System.out.println(person == person2);
	}
	
	@Test
	public void testPagingAndSortingRepository() {
		Order order1 = new Order(Direction.DESC, "id");
		Order order2 = new Order(Direction.ASC, "email");
		Sort sort = new Sort(order1, order2);
		
		int pageNo = 5 - 1;
		int pageSize = 5;
		Pageable pageable = new PageRequest(pageNo, pageSize, sort);
		Page<Person> page = personRepository.findAll(pageable);
		System.out.println("总记录数：" + page.getTotalElements());
		System.out.println("当前第几页：" + (page.getNumber() + 1));
		System.out.println("总页数：" + page.getTotalPages());
		System.out.println("当前页面的List：" + page.getContent());
		System.out.println("当前页面的记录数：" + page.getNumberOfElements());
	}
	
	@Test
	public void testCrudRepository() {
		List<Person> persons = new ArrayList<Person>();
		for(int i='a'; i<='z';i++) {
			Person person = new Person();
			person.setAddressId(i + 1);
			person.setBirth(new Date());
			person.setEmail((char)i + "" + (char)i + "@163.com");
			person.setName((char)i + "" + (char)i);
			persons.add(person);
		}
		personService.savePersons(persons);
	}
	
	@Test
	public void testModifying() {
		personService.updatePersonEmail("dd@163.com", 1);
	}
	
	@Test
	public void testNaiveQuery() {
		long count = personRepository.getTotalCount();
		System.out.println(count);
	}
	
	@Test
	public void testQueryAnnotationLikeParam() {
		List<Person> persons = personRepository.testQueryAnnotationLikeParam("A", "bb");
		System.out.println(persons);
	}
	
	@Test
	public void testQueryAnnotationParam2() {
		List<Person> persons = personRepository.testQueryAnnotationParam2("aa@163.com","AA");
		System.out.println(persons);
	}
	
	@Test
	public void testQueryAnnotationParam1() {
		List<Person> persons = personRepository.testQueryAnnotationParam1("AA", "aa@163.com");
		System.out.println(persons);
	}
	
	@Test
	public void testQueryAnnotation() {
		Person person = personRepository.getMaxIdPerson();
		System.out.println(person);
	}
	
	@Test
	public void testKeywords2() {
		List<Person> persons = personRepository.getByAddress_IdGreaterThan(1);
		System.out.println(persons);
	}
	
	@Test
	public void testKeyWords() {
		List<Person> persons = personRepository.getByNameStartingWithAndIdLessThan("X", 10);
		System.out.println(persons);
		
		persons = personRepository.getByNameEndingWithAndIdLessThan("X", 10);
		System.out.println(persons);
		
		persons = personRepository.getByEmailInOrBirthLessThan(Arrays.asList("aa@163.com", "bb@163.com"), new Date());
		System.out.println(persons);
	}
	
	@Test
	public void testHelloWorldSpringData() {
		PersonRepository personRepository = context.getBean(PersonRepository.class);
		Person person = personRepository.getByName("AA");
		System.out.println(person);
	}
	
	@Test
	public void testJPA() {
		
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
