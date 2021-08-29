package Greedy;
import java.util.*;
import java.io.*;
public class BOJ3052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[43];
        for(int i = 0 ; i < 10 ; i++ ){
            arr[Integer.parseInt(br.readLine()) % 42]++;
        }
        int cnt = 0;
        for(int i = 0 ; i < 43 ; i++ ){
            if(arr[i] > 0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
}
