package Permutation_And_Comb;
import java.util.*;
import java.io.*;

public class SW9229 {
    public static int max;
    public static int[]  arr;
    public static int  maxV = -1;

    public static void func(  int currWeight , int depth,  int r){
        if (currWeight > max){return;}
        if(r == 0){
            maxV = Math.max(maxV ,currWeight );
            return;
        }
        if(depth == arr.length){return;}

        func(  currWeight + arr[depth] , depth+1 ,   r -1);
        func(  currWeight , depth+1 ,   r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt( br.readLine());
        StringTokenizer str = null;
        for(int test_case = 1; test_case <= TC; test_case++){
            str = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(str.nextToken());
            max = Integer.parseInt(str.nextToken());
            str = new StringTokenizer(br.readLine());
            arr = new int[len];
            for(int i = 0 ; i < len ; i++){
                arr[i] = Integer.parseInt(str.nextToken());
            }
            maxV = -1;
            func(  0 , 0 ,   2);
            System.out.println("#" + test_case + " "+maxV);
        }
    }
    
}
