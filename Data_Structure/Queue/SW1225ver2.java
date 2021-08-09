package Data_Structure.Queue;
import java.util.*;
import java.io.*;

public class SW1225ver2 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = null;
		int[] numbers = new int[8];
		Queue<Integer> q = new LinkedList<>();
		for (int t = 1; t <= 10; t++) {
			br.readLine();  // 테스트 케이스 번호 : 사용안함
			tokens = br.readLine().split(" ");
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				numbers[i] = Integer.parseInt(tokens[i]);
				min = Math.min(min, numbers[i]);
			}
//			System.out.println("min -> " + min);
			
			// 공통으로 차감할 수 있는 최대 숫자 구하기
			int v = min / 15 * 15;
			// v == min 이 같은 경우 -15 한다.
			if (v != 0 && min == v) v -= 15;
			
//			System.out.println(v);
			q.clear();
			for (int i = 0; i < 8; i++) {
				q.add(numbers[i] - v);
			}
//			System.out.println(Arrays.toString(numbers));
//			System.out.println(q);
			int minus = 1, tmp = 0;
			while (true) {
				tmp = q.poll() - minus;
				if (tmp <= 0) {
					q.offer(0);
					break;
				}
				q.offer(tmp);
				
				minus = minus % 5 + 1;
			}
			System.out.print("#" + t + " ");
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}

}
