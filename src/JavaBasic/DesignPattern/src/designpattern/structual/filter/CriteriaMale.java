package designpattern.structual.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria
{
	public List<Person> meetCriteria(List<Person> persons)
	{
		List<Person> malePersons = new ArrayList<Person>();
		for(Person person : persons)
		{
			if(person.getGender().equalsIgnoreCase("Male"))
			{
				malePersons.add(person);
			}
		}
		return malePersons;
	}
}
