package javamxj.spring.beginning2;

public class HelloFactory
{
	public Hello getHello(String hello)
	{
		if(hello.equals("world"))
		{
			return new HelloWorld();
		}
		else if(hello.equals("javamxj"))
		{
			return new HelloJavamxj();
		}
		else
		{
			throw new IllegalArgumentException(" ‰»Î≤Œ ˝¥ÌŒÛ");
		}
	}
}
