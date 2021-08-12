package Permutation_And_Comb;

import java.util.*;
import java.io.*;

public class BOJ2961 {
    public static int N , minV = Integer.MAX_VALUE;
    public static Ingredient[] ingre;


    public static void func(int depth  , int totalSour, int totalBitter ){
        if(depth == N && totalSour != 1 && totalBitter != 0 ){
            minV = Math.min(minV , Math.abs(totalSour - totalBitter));
            return;
        }
        if(depth == N  ){return;}

        func(depth + 1 ,totalSour* ingre[depth].sour ,  totalBitter+ingre[depth].bitter);
        func(depth + 1 ,totalSour ,  totalBitter);
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Permutation_And_Comb/BOJ2961.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingre  = new Ingredient[N];
        StringTokenizer str = null;
        for( int i = 0 ; i < N ; i++){
            str = new StringTokenizer(br.readLine());
            ingre[i] = new Ingredient(Integer.parseInt(str.nextToken()) , Integer.parseInt(str.nextToken()));
        }
        func( 0 ,  1 , 0);
        System.out.println(minV);

    }
}
class Ingredient{
    int sour;
    int bitter;
    public Ingredient(int sour , int bitter){
        this.sour = sour;
        this.bitter = bitter;
    }
}
