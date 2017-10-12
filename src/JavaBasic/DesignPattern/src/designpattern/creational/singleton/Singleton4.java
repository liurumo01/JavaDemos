package designpattern.creational.singleton;

//双检锁/双重校验锁（DCL）式单例模式，有其它特殊需求时使用
public class Singleton4
{
	private volatile static Singleton4 singleton;
	private Singleton4() {}
	public static Singleton4 getSingleton()
	{
		if(singleton != null)
		{
			synchronized (Singleton4.class)
			{
				if(singleton == null)
				{
					singleton = new Singleton4();
				}
			}
		}
		return singleton;
	}
}
