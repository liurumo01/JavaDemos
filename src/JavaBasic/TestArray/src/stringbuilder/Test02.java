package stringbuilder;

public class Test02 {
	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
		sb.delete(3, 5).delete(3,5);
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		//StringBuffer sb2 = new StringBuffer();
	}
}
