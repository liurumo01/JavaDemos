package designpattern.creational.abstractfactory;

public class FactoryProducer
{
	public static AbstractFactory getFactory(String choice)
	{
		if(choice == "Shape")
		{
			return new ShapeFactory();
		}
		else if(choice == "Color")
		{
			return new ColorFactory();
		}
		return null;
	}
}
