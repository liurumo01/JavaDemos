package space.snowwolf.springmvc.handler;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static <T> void show(Queue<T> q) {
		while (!q.isEmpty()) {
			T tmp = q.poll();
			System.out.println(tmp);
		}
		System.out.println("==============");
	}
	
	public static void main(String[] args) // throws FileNotFoundException
	{
		Queue<Integer> q1 = new LinkedList<>();
		q1.add(1);
		q1.add(2);
		System.out.println(q1);
		Queue<node> q2 = new LinkedList<>();
		q2.add(new node(1,1,1));
		q2.add(new node(2,2,2));
		System.out.println(q2);
		
		/*Scanner in = new Scanner(System.in);
		// InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		// Scanner in=new Scanner(new File("permutations.in"));
		// PrintWriter out = new PrintWriter(new File("permutations.out"));
		while (in.hasNext()) {
			char[] s = in.nextLine().toCharArray();
			int x = (int) (s[0] - 'a' + 1);
			ansx = (int) (s[3] - 'a' + 1);
			int y = (int) (s[1] - '0');
			ansy = (int) (s[4] - '0');
			// System.out.println(x+" "+ansx+" "+y+" "+ansy);
			out.println("To get from " + s[0] + s[1] + " to " + s[3] + s[4] + " takes " + bfs(x, y) + " knight moves.");
		}
		in.close();
		out.close();*/
	}

	static int[] xx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] yy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int ansx, ansy;

	static int bfs(int x, int y) {
		if (x == ansx && y == ansy)
			return 0;
		boolean[][] vis = new boolean[1005][1005];
		node fron = new node(x,y,0);
		node rear = new node();
		Queue<node> q = new LinkedList<node>();
		q.clear();
		vis[x][y] = true;
		q.add(fron);
		//System.out.println(q);
		while (!q.isEmpty()) {
			fron = q.poll();
			//show(q);
			System.out.println(q);
			for (int i = 0; i < 8; i++) {
				int dx = fron.x + xx[i];
				int dy = fron.y + yy[i];
				if (dx > 0 && dx <= 8 && dy <= 8 && dy > 0 && !vis[dx][dy]) {
					System.out.println(dx + " " + dy);
					vis[dx][dy] = true;
					if (dx == ansx && dy == ansy)
						return fron.step + 1;
					rear.x = dx;
					rear.y = dy;
					rear.step = fron.step + 1;
					q.add(rear);
				}
			}
		}
		return -1;
	}
}

class node {

	int x, y, step;
	
	@Override
	public String toString() {
		return "node [x=" + x + ", y=" + y + ", step=" + step + "]";
	}

	public node() {
		// TODO Auto-generated constructor stub
	}

	public node(int x, int y, int step) {
		super();
		this.x = x;
		this.y = y;
		this.step = step;
	}
	
}
