import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("in.txt"));
		System.setOut(new PrintStream(new FileOutputStream("out.txt")));

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			System.out.println(sc.nextInt() + 1);
		}
		sc.close();
	}
}
