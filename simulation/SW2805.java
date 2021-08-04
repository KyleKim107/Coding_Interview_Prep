package simulation;

import java.util.*;

public class SW2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; ++i) {
				String str = sc.next();
				for (int j = 0; j < N; ++j) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			int cnt = 0, area = 0, mid = (N / 2);
			for (int i = 0; i < N; ++i) {
				int start = mid - area; //시작점
				int end = mid + area; // 끝
                System.out.printf("mid " +mid +" area "+area + " start "+ start + " end " + end);
				for (int j = start; j <= end; ++j) {
					cnt += arr[i][j];
				}
				
				if (i >= mid) {
					area--;
				} else {
					area++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
		
		sc.close();
    }

    // 농작물에서 가운뎃줄은 무조건 구해야 하므로
    
}
