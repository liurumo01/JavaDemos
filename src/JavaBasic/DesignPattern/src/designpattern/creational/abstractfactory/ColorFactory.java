package designpattern.creational.abstractfactory;

public class ColorFactory extends AbstractFactory
{
	public Shape getShape(String shpeType)
	{
		return null;
	}
	
	Color getColor(String color)
	{
		switch(color)
		{
		case "Red":
			return new Red();
		case "Green":
			return new Green();
		case "Blue":
			return new Blue();
		default:
			return null;	
		}
	}
}
