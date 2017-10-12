package designpattern.structual.decorator;

public class RedShapeDecorator extends ShapeDecorator
{
	public RedShapeDecorator(Shape decoratedShape)
	{
		super(decoratedShape);
	}
	
	public void draw()
	{
		decoratoredShape.draw();
		setRedBorder(decoratoredShape);
	}
	
	private void setRedBorder(Shape decoratedShape)
	{
		System.out.println("Border Color:Red");
	}
}
