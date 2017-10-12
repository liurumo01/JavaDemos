package designpattern.j2ee.businessdelegate;

public class EJBSeivice implements BusinessService
{
	public void doProcessing()
	{
		System.out.println("Processing task by invoking EJB Service");
	}
}
