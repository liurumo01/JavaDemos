package space.snowwolf.springdata;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person>, PersonDAO {

	public Person getByName(String name);
	
	public List<Person> getByNameStartingWithAndIdLessThan(String name, Integer id);
	
	public List<Person> getByNameEndingWithAndIdLessThan(String name, Integer id);
	
	public List<Person> getByEmailInOrBirthLessThan(List<String> emails, Date birth);
	
	public List<Person> getByAddress_IdGreaterThan(Integer id);
	
	@Query("select p from Person p where p.id = (select max(p2.id) from Person p2)")
	public Person getMaxIdPerson();
	
	@Query("select p from Person p where p.name = ?1 and p.email = ?2")
	public List<Person> testQueryAnnotationParam1(String name, String email);
	
	@Query("select p from Person p where p.name = :name and p.email = :email")
	public List<Person> testQueryAnnotationParam2(@Param("email") String email, @Param("name") String name);
	
	@Query("select p from Person p where p.name like %?1% or p.email like %?2%")
	public List<Person> testQueryAnnotationLikeParam(String name, String email);
	
	@Query(value="select count(id) from jpa_persons", nativeQuery=true)
	public long getTotalCount();
	
	@Modifying
	@Query("update Person p set p.email = :email where id = :id")
	public void updatePersonEmail(@Param("id") Integer id, @Param("email") String email);

}
