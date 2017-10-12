package designpattern.creational.abstractfactory;

public class ShapeFactory extends AbstractFactory
{
	public Shape getShape(String shapeType)
	{
		switch(shapeType)
		{
		case "Circle":
			return new Circle();
		case "Square":
			return new Square();
		case "Rectangle":
			return new Rectangle();
		default:
			return null;
		}
	}
	
	Color getColor(String color)
	{
		return null;
	}
}
