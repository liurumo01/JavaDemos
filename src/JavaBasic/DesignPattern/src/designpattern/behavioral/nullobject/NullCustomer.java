package designpattern.behavioral.nullobject;

public class NullCustomer extends AbstractCustomer
{
	public String getName()
	{
		return "Not Available in Customer DataBase";
	}
	
	public boolean isNil()
	{
		return true;
	}
}
