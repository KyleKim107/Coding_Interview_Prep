package Dynamic_Programming.Floyd;

import java.util.*;
import java.io.*;

public class Human_network {

    public static int N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Dynamic_Programming/Floyd/HU.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int INF = 99999;
        for (int test = 1; test <= TC; test++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            N = Integer.parseInt(str.nextToken());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int tmp = Integer.parseInt(str.nextToken());
                    if (i != j && tmp == 0) {
                        arr[i][j] = INF;
                    } else {
                        arr[i][j] = tmp;
                    }

                }
            }
            for (int mid = 0; mid < N; mid++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (mid == i || mid == j || i == j)
                            continue;
                        arr[i][j] = Math.min(arr[i][mid] + arr[mid][j], arr[i][j]);
                    }
                }
            }
            // for(int i = 0 ; i < N ; i++ ){
            //     System.out.println(Arrays.toString(arr[i]));
            // }
            int minV = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += arr[i][j];
                }
                minV = Math.min(sum , minV);
            }
            System.out.println("#" + test +  " "+minV);
        }

    }
}
