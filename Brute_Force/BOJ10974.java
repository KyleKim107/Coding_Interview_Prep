package Brute_Force;
import java.util.*;


public class BOJ10974 {
    public static void func(int[] arr, int[] visit, int[] output  , int len){
        if(len == arr.length){
            for(int n : output){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(visit[i]== 0){
                visit[i] = 1;
                output[len] = arr[i];
                func(arr , visit, output , len + 1 );
                output[len] = 0;
                visit[i] = 0;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++ ){
            arr[i] = sc.nextInt();
        }
        int[] visit = new int[N];
        int[] output = new int[N];
        int len = 0;
        func(arr , visit, output , len );
    }
    
}
