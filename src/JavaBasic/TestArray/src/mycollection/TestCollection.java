package mycollection;

public class TestCollection {
	public static void main(String[] args) {
		MyArrayList l = new MyArrayList();
		for(int i=0;i<100;i++)
		{
			l.add(i);
			System.out.print(l.size() + "  ");
		}
		
		for(int i=0;i<100;i++)
		{
			System.out.println(l.get(i));
			
		}
	}
	
}
