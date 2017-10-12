package designpattern.creational.singleton;

//饿汉式单例模式，一般情况下使用
public class Singleton1
{
	private static Singleton1 instance = new Singleton1();
	private Singleton1() {}
	public static Singleton1 getInstance()
	{
		return instance;
	}
}
