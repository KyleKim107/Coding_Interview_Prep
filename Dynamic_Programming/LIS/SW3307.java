package Dynamic_Programming.LIS;

import java.util.*;
import java.io.*;

public class SW3307 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Dynamic_Programming/LIS/SW3307.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            dp[0] = 1;// 처음엔 무조건 하나가 오기에
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(str.nextToken());
            }
            System.out.println(Arrays.toString(arr) + "\n");
            int maxV = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    // 이전값이 자신보다 작고, 이전것의 최대 길이의 +1 이 더 긴경우
                    if (arr[j] < arr[i] && dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;
                }
                System.out.println(Arrays.toString(dp));
                maxV = Math.max(dp[i], maxV);
            }
            System.out.println("#" + test + " " + maxV);

        }
    }

}
