package designpattern.structual.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria
{
	public List<Person> meetCriteria(List<Person> persons)
	{
		List<Person> femalePersons = new ArrayList<Person>();
		for(Person person : persons)
		{
			if(person.getGender().equalsIgnoreCase("Female"))
			{
				femalePersons.add(person);
			}
		}
		return femalePersons;
	}
}
