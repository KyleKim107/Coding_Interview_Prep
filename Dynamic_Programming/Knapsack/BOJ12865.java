package Dynamic_Programming.Knapsack;
import java.util.*;
import java.io.*;
public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Dynamic_Programming/Knapsack/BOJ12865.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), K = Integer.parseInt(str.nextToken());
        int[][] dp = new int[101][25];
        int[] v= new int[N+1] , w = new int[N +1];
        for(int i = 1 ; i <= N ; i++ ){
            str = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(str.nextToken());
            v[i] = Integer.parseInt(str.nextToken());
        }
        for(int i = 1 ; i <= N ; i++ ){
            for(int j = 1 ; j <= K ; j++ ){
                if(j-w[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j - w[i]] + v[i] );
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i = 0 ; i <= N ; i++ ){
            System.out.println(Arrays.toString(dp[i]));

        }
        System.out.println(dp[N][K]);
    }
}
