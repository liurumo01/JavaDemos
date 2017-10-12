import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double t = sc.nextDouble();
		for (int i = 0; i < 10; i++) {
			double s = sc.nextDouble();
			if(s >= t) {
				System.out.print(i+1);
				break;
			} else if(i == 9) {
				System.out.print(0);
			}
		}
		sc.close();
	}
}
