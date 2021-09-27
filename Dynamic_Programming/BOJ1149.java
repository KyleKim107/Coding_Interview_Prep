package Dynamic_Programming;

import java.util.*;
import java.io.*;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = null;
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(str.nextToken());
            dp[i][1] = Integer.parseInt(str.nextToken());
            dp[i][2] = Integer.parseInt(str.nextToken());
        }
        for(int i = 1 ; i < N ; i++ ){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+dp[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+dp[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+dp[i][2];
        }
        System.out.println( Math.min( Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2] ));
    }

}
