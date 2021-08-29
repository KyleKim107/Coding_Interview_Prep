package SWEA;

import java.util.*;
import java.io.*;

public class SW1238 {
    public static void main(String[] args) throws IOException{
        System.setIn( new FileInputStream("SWEA/SW1238.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        for(int test = 1 ; test <= 10 ; test++ ){
            str = new StringTokenizer( br.readLine());
            int N = Integer.parseInt(str.nextToken()), start = Integer.parseInt(str.nextToken());
            int maxV = Integer.MIN_VALUE;
            int[] visit = new int[N +1];
            int[] arr = new int[N];
            str = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ;i++){
                arr[i] = Integer.parseInt(str.nextToken());
            }
            visit[start] = 1;
            Queue<Integer> Q = new LinkedList<>();
            Q.offer(start);
            while(!Q.isEmpty()){
                int len = Q.size(); maxV = Integer.MIN_VALUE;
                for(int i = 0 ; i <  len ; i++){
                    int from = Q.poll();
                    maxV = Math.max(maxV ,from );
                    for(int j = 0 ; j < N ; j+=2 ){
                        if(arr[j] == from && visit[ arr[j+1] ] == 0 ){
                            Q.offer(arr[j+1] );
                            visit[ arr[j+1]  ]= 1;
                        }
                    }
                }
            }
            System.out.println("#" + test + " "+ maxV);
        }
        }
}


