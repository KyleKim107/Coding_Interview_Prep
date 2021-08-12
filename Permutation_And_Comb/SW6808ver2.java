package Permutation_And_Comb;

import java.util.*;
import java.io.*;

public class SW6808ver2 {
    public static int[] enermy;
    public static int[] me, curr;
    public static int win, lose;

    public static void fight(int[] curr ){
        int my = 0 , your = 0;
        for(int i = 0 ; i < 9 ; i++){
            if (curr[i] > enermy[i] ){
                my += (curr[i] + enermy[i]);
            }else{
                your += (curr[i] + enermy[i]);
            }
        }
        if (my > your){
            win += 1;
        }else if(my < your){
            lose += 1;
        }
    }

    public static void func(int flag, int depth ){
        if (depth == 9){
            // System.out.println(Arrays.toString(curr));
            fight(curr);
            return;
        }
        System.out.println(flag);
        for(int i = 0 ; i < 9 ; i++){
            if((flag & 1 << i) != 0){continue;}
                curr[depth] = me[i];
                func(flag| 1 << i  , depth +1);
        }
    }
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Permutation_And_Comb/SW6808.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(str.nextToken());
        for(int  test_case = 1 ; test_case <= num; test_case ++){
            int[] numArr = new int[19];
            str = new StringTokenizer(br.readLine());
            enermy = new int[9]; int index = 0;
            for(int q = 0 ; q < 9 ; q++){
                int curr = Integer.parseInt(str.nextToken());
                numArr[curr]++;
                enermy[index++] = curr;
            }
            index = 0;
            me = new int[9];
            for(int q = 1 ; q < 19 ; q++){
                if (numArr[q] == 0){
                    me[index++] =  q;
                }
            }
            curr =new int[9];
            win =0; lose = 0;
            func(0 , 0 );
            System.out.println("#" + test_case+" " + lose + " " + win); // 규영이가 나였구나....
        }
    }
}
