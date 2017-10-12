package space.snowwolf.jpa.helloworld;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Item {

	private Integer id;
	private String name;
	private Set<Category> categories = new HashSet<Category>();

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	@JoinTable(joinColumns = { @JoinColumn(name = "item_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "catgory_id", referencedColumnName = "id") })
	public Set<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}
