package Greedy;

import java.util.*;
import java.io.*;

public class BOJ3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        int maxV = Integer.MIN_VALUE;
        int maxIndex =  10000, realMax =Integer.MIN_VALUE, realIndex = -1;
        int[] arr = new int[N];
        StringTokenizer str = null;
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken()), b = Integer.parseInt(str.nextToken());
            int abs = Math.abs(a-b);
            if ( abs >= maxV ) {
                if(abs > maxV){
                    maxIndex = i + 1;
                    maxV = abs;
                }
                else if( abs == maxV  && i < maxIndex){
                   maxIndex = i + 1;
                   maxV = abs;
                }
            }
            
            int cnt = 0;
            for (int j = a - 1; j <b; j++) {
                if(arr[j] == 0){
                    arr[j] = i+1;
                    cnt ++;
                }
            }

            if(realMax < cnt){
                realIndex = i + 1;
                realMax = cnt;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(maxIndex);
        System.out.println(realIndex);

    }

}
