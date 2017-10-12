package designpattern.behavioral.iterator;

public class NameRepository implements Container
{
	public String names[] = {"Robert","John","Julie","Lora"};
	
	public Iterator getIterator()
	{
		return new NameIterator();
	}
	
	private class NameIterator implements Iterator
	{
		int index;
		
		public boolean hasNext()
		{
			return index < names.length ? true : false;
		}
		
		public Object next()
		{
			return this.hasNext() ? names[index++] : null;
		}
	}
}
