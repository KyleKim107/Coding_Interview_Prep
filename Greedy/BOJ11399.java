package Greedy;

import java.util.*;
import java.io.*;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Greedy/BOJ11399.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer str= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0 , tmp = 0;
            for(int i = 0 ; i < arr.length ; i++ ){
                cnt += tmp +arr[i];
                tmp += arr[i];
            }
        System.out.println(cnt);
    }
}
