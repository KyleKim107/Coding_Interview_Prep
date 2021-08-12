package Data_Structure.Queue;
import java.util.*;
import java.io.*;

public class BOJ1158_2 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = k + 1; i <= n; ++i)
			que.offer(i);
		for (int i = 1; i < k; ++i)
			que.offer(i);

		StringBuilder sb = new StringBuilder();
		sb.append("<" + k);

		int count = 0;
		while (! que.isEmpty()) {
			int element = que.poll();
			count++;
			if (count != k)
				que.offer(element);
			else {
				count = 0;
				sb.append(", " + element);
			}
		}
		bw.write(sb.append(">").toString());

		br.close();
		bw.close();
	}
}
