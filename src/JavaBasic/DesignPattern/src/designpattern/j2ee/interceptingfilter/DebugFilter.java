package designpattern.j2ee.interceptingfilter;

public class DebugFilter implements Filter
{
	public void execute(String request)
	{
		System.out.println("request log:" + request);
	}
}
