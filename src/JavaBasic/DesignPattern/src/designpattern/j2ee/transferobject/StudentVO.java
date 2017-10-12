package designpattern.j2ee.transferobject;

public class StudentVO
{
	private String name;
	private int roolNo;
	
	public StudentVO(String name,int roolNo)
	{
		this.name = name;
		this.roolNo = roolNo;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getRoolNo()
	{
		return roolNo;
	}
	public void setRoolNo(int roolNo)
	{
		this.roolNo = roolNo;
	}
}
