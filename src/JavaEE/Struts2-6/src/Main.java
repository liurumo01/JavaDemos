import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int s = sc.nextInt();
		int n = sc.nextInt();
		int[][] a = new int[m][s];
		int[][] b = new int[s][n];
		int[][] c = new int[m][n];
		int i, j, k;

		for (i = 0; i < m; i++) {
			for (j = 0; j < s; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (i = 0; i < s; i++) {
			for (j = 0; j < n; j++) {
				b[i][j] = sc.nextInt();
			}
		}
		sc.close();
		for (i = 0; i < c.length; i++) {
			for (k = 0; k < a[i].length; k++) {
				if (a[i][k] != 0) {
					for (j = 0; j < c[i].length; j++) {
						c[i][j] += a[i][k] * b[k][j];
					}
				}
			}
		}
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}
