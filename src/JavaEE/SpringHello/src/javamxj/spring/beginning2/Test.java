package javamxj.spring.beginning2;

public class Test
{
	public static void main(String[] args)
	{
		Hello hello =null;
		HelloFactory factory = new HelloFactory();
		
		hello = factory.getHello("world");
		hello.sayHello();
		
		hello = factory.getHello("javamxj");
		hello.sayHello();
	}
}
