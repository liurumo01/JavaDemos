package designpattern.behavioral.interpreter;

public class TerminalExpression implements Expression
{
	private String data;
	
	public TerminalExpression(String data)
	{
		this.data = data;
	}
	
	public boolean interpret(String context)
	{
		return context.contains(data) ? true: false;
	}
}
