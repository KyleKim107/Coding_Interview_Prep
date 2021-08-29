package Greedy;

import java.util.*;
import java.io.*;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Greedy/BOJ2798.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken());
        int[] arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (arr[i] + arr[j] + arr[k] <= M) {
                        maxV = Math.max(maxV, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        System.out.println(maxV);
    }

}
