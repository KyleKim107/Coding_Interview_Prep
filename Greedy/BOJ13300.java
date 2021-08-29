package Greedy;

import java.util.*;
import java.io.*;

public class BOJ13300 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Greedy/BOJ13300.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), K = Integer.parseInt(str.nextToken());
        int[][] arr = new int[7][2];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(str.nextToken());
            int grade = Integer.parseInt(str.nextToken());
            arr[grade][gen]++;
        }
        int cnt = 0;
        for (int i = 1; i < 7; i++) {
            cnt += arr[i][0] / K;
            cnt += ((arr[i][0] % K == 0) ? 0 : 1);
            cnt += arr[i][1] / K;
            cnt += ((arr[i][1] % K == 0) ? 0 : 1);
        }
        System.out.println(cnt);

    }

}

// for(int i = 1 ; i < 7 ; i++ ){
// System.out.println(Arrays.toString(arr[i]));
// }