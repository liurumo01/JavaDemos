package javamxj.spring.beginning4;

public class HelloBean
{
	private String helloWorld;
	
	public HelloBean(String hellowWorld)
	{
		this.helloWorld = hellowWorld;
	}
	
	public void sayHello()
	{
		System.out.println(helloWorld);
	}
}
