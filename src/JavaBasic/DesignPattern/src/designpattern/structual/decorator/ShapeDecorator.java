package designpattern.structual.decorator;

public abstract class ShapeDecorator implements Shape
{
	protected Shape decoratoredShape;
	
	public ShapeDecorator(Shape decoratedShape)
	{
		this.decoratoredShape = decoratedShape;
	}
	
	public void draw()
	{
		decoratoredShape.draw();
	}
}
