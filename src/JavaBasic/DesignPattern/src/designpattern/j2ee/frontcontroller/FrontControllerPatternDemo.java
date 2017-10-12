package designpattern.j2ee.frontcontroller;

public class FrontControllerPatternDemo
{
	public static void main(String[] args)
	{
		FrontController frontController = new FrontController();
		frontController.dispatchedRequest("Home");
		frontController.dispatchedRequest("Student");
	}
}
