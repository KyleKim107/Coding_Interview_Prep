package Permutation_And_Comb;

import java.util.*;
import java.io.*;

public class SW4012 {
    public static int[][] arr;
    public static int N, minV;

    public static void func(int depth, int[] visit , int r ){
        if(r == N /2){
            int first = 0, second = 0;
            for(int i = 0 ; i < N -1 ; i++){
                for(int j = i + 1; j < N ; j++){
                    if(i == j || visit[i] != visit[j] ){continue;}
                    if(visit[i] == 1){
                        first += (arr[i][j] + arr[j][i]);
                    }else{
                        second += (arr[i][j] + arr[j][i]);
                    }
                }
            }
            minV = Math.min( minV , Math.abs(first - second));
            return;
        }
        if(depth == N){return;}


        visit[depth] = 1;
        func(depth + 1 , visit, r + 1);
        visit[depth] = 0;
        func(depth + 1 , visit, r );

    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Permutation_And_Comb/SW4012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Test = Integer.parseInt(br.readLine());
        StringTokenizer str = null;
        for (int test = 1; test <= Test; test++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                str = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            minV = Integer.MAX_VALUE;
            func(0 , new int[N] ,0);
            System.out.println("#" + test+ " " + minV);
        }

    }
}
