package org.tianyuan.sorm.vo;

public class EmpVo {
	
	private Integer id;
	private String empname;
	private Double salarySum;
	private Integer age;
	private String deptName;
	private String deptAddress;
	
	public EmpVo() {
		
	}
	public EmpVo(Integer id, String empname, Double salarySum, Integer age,
			String deptName, String deptAddress) {
		super();
		this.id = id;
		this.empname = empname;
		this.salarySum = salarySum;
		this.age = age;
		this.deptName = deptName;
		this.deptAddress = deptAddress;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Double getSalarySum() {
		return salarySum;
	}
	public void setSalarySum(Double salarySum) {
		this.salarySum = salarySum;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptAddress() {
		return deptAddress;
	}
	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(id + ",").append(empname + ",").append(salarySum + ",").append(age + ",").append(deptName + ",").append(deptAddress + "]");
		return builder.toString();
	}
}
