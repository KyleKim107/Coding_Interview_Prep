package Brute_Force;

import java.io.*;
import java.util.*;

public class BOJ1759 {
    public static int L,C;
    public static char[] arr;
    public static void func(int depth, int r , char[] curr, int mo, int ja){
        if(r  == L &&  mo >= 1 && ja >= 2 ){
            for(int i = 0 ; i < L ; i++){
                System.out.print(curr[i]);
            }
            System.out.println();
            return;
        }
        if( r == L||depth == C){
            return;}

        char tmp = arr[depth];
        int m = 0 ,j = 0;
        if("aeiou".indexOf(tmp) >= 0){
            m += 1;
        }else{
            j += 1;
        }
        curr[r] = tmp;
        func(depth + 1, r +1 , curr , mo + m , ja + j);
        func(depth + 1, r  , curr , mo  , ja );
        
    }
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Brute_Force/BOJ1759.txt"));
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        L = Integer.parseInt(str.nextToken()); C = Integer.parseInt(str.nextToken());
        arr = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(arr);
        func(0 , 0, new char[L], 0 ,0);
    }
    
}
