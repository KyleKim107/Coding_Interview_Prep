package Dynamic_Programming.Floyd;

import java.util.*;
import java.io.*;

public class JA1681 {
    static int[][] arr;
    static int N, minV = Integer.MAX_VALUE;
    public static void func(int index  ,int[] visit , int total, int cnt){
        if(total > minV) return;
        if(cnt == N-1 && arr[index][0] != 0){
            minV = Math.min( minV, total + arr[index][0] );
            return;
        }
        for(int i = 1 ; i < N ; i++ ){
            if( arr[index][i] != 0  && visit[i] == 0 ){
                visit[i] = 1;
                func(i , visit , total + arr[index][i], cnt +1 );
                visit[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Dynamic_Programming/Floyd/JA1681.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer str = null;
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
            func(0 , new int[N], 0, 0 );
            System.out.println(minV);

    }
}
