package Greedy.TwoPointer;

import java.util.*;
import java.io.*;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Greedy/TwoPointer/BOJ1806.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), minV = Integer.MAX_VALUE , lo = 0, hi = 0;
        long M = Integer.parseInt(str.nextToken()) , total = 0;

        int[] arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++ ){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        while(true){
            // lo 조건
            if(total >= M) total -= arr[lo++];
            else if(hi == N) break;
            else total += arr[hi++];
            if(total >= M){
                // System.out.println(lo + " " + hi + " Math.abs(lo-hi) : " + Math.abs(lo-hi)) ;
                minV = Math.min(minV , Math.abs(lo-hi)  );
            }
        }
        System.out.println(minV == Integer.MAX_VALUE? 0 : minV );
    }
}
