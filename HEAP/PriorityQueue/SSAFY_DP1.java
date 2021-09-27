package HEAP.PriorityQueue;

import java.util.*;
import java.io.*;

public class SSAFY_DP1 {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("<file path>"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer str = new StringTokenizer(br.readLine());

        // Q1
        int[] dp = new int[1000];
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[8]);

        // Q2
        int[] dp2 = new int[1000];
        dp2[1] = 2;
        dp2[2] = 5;
        for (int i = 3; i < dp2.length; i++) {
            dp2[i] = (dp2[i - 1] * 2) + dp2[i - 2];
            // 파,초 추가 + 빨간색 다음에 색추가
        }
        System.out.println(dp2[6]);

    }

}
