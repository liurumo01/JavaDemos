package designpattern.j2ee.businessdelegate;

public class BusinessLookUp
{
	public BusinessService getBusinessService(String serviceType)
	{
		return serviceType.equalsIgnoreCase("EJB") ? new EJBSeivice() : new JMSService();
	}
}
