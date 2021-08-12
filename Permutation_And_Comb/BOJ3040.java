package Permutation_And_Comb;

import java.util.*;
import java.io.*;

public class BOJ3040 {
    public static int[] dwarf;
    public static int N;

    public static void func( int depth,  int sum , int[] check , int manNum){
        if ( manNum == 7 && sum == 100 ){
            for(int i = 0 ; i < N ; i++){
                if(check[i]== 1){
                    System.out.println(dwarf[i]);
                }
            }
            return;
        }
        if(depth == N || sum >= 100 ){return ;}

        check[depth] = 1;
        func(depth + 1, sum+dwarf[depth] , check , manNum +1);
        check[depth] = 0;
        func(depth + 1, sum , check ,manNum );

    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Permutation_And_Comb/BOJ3040.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf  = new int[9];N = 9;
        for(int i = 0 ; i < 9 ; i++){
            dwarf[i] = Integer.parseInt(br.readLine());
        }
        func( 0 , 0 , new int[N] , 0);

    }

}
