package designpattern.creational.singleton;

//登记式/静态内部类单例模式，只有在要明确实现lazy loading效果时使用
public class Singleton2
{
	private static class SingletonHolder
	{
		private static final Singleton2 INSTANCE = new Singleton2();
	}
	private Singleton2() {}
	public static final Singleton2 getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
}
