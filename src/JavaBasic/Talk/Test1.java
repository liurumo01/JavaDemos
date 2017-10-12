import java.util.Scanner;
import java.util.Comparator;
public class Test1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] para = line.split(" |\t");
		int[] t = new int[10];
		for(int i=0;i<para.length;i++)
		{
			t[i] = Integer.valueOf(para[i]);
		}
		for(int i=0;i<para.length;i++)
		{
			System.out.println(t[i]);
		}
	}
}