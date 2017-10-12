package designpattern.creational.abstractfactory;

public class AbstractFactoryPatternDemo
{
	public static void main(String[] args)
	{
		AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");
		
		Shape shape1 = shapeFactory.getShape("Circle");
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("Rectangle");
		shape2.draw();
		
		Shape shape3 = shapeFactory.getShape("Square");
		shape3.draw();
		
		AbstractFactory colorFactory = FactoryProducer.getFactory("Color");
		
		Color color1 = colorFactory.getColor("Red");
		color1.fill();
		
		Color color2 = colorFactory.getColor("Green");
		color2.fill();
		
		Color color3 = colorFactory.getColor("Blue");
		color3.fill();
	}
}
