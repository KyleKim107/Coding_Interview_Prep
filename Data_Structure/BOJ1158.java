package Data_Structure;

import java.util.*;

public class BOJ1158 {
	public static void main(String[] rg) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++)
			q.add(i);
		System.out.print("<");
		while (q.size() > 1) {
			for (int i = 0; i < M - 1; i++)
				q.add(q.poll());
			System.out.print(q.poll() + ", ");
		}
		System.out.print(q.poll() + ">");
	}
}