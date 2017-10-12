package space.snowwolf.jpa.helloworld;

import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@NamedQuery(name="testNamedQuery", query="select c from Customer c where c.id = ?")
@Cacheable(true)
@Entity
@Table(name = "customers")
public class Customer {

	private Integer id;
	private String name;
	private String email;
	private int age;
	private Date createTime;
	private Date birth;
	
	private Set<Order> orders;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//@TableGenerator(name = "ID_GENERATOR", table = "id_generators", pkColumnName = "pk_name", pkColumnValue = "customer_id", valueColumnName = "pk_value", allocationSize = 100)
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@JoinColumn(name="customer_id")
	@OneToMany
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Transient
	public String getInfo() {
		return "name:" + name + ", email:" + email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", createTime="
				+ createTime + ", birth=" + birth + ", orders=" + orders + "]";
	}

}
