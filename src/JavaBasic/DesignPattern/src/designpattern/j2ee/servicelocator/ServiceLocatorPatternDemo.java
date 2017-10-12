package designpattern.j2ee.servicelocator;

public class ServiceLocatorPatternDemo
{
	public static void main(String[] args)
	{
		Service service = SeviceLocator.getService("Service1");
		service.execute();
		service = SeviceLocator.getService("Service2");
		service.execute();
		service = SeviceLocator.getService("Service1");
		service.execute();
		service = SeviceLocator.getService("Service2");
		service.execute();
	}
}
