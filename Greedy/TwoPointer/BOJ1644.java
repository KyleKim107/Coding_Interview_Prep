package Greedy.TwoPointer;
import java.util.*;
import java.io.*;
public class BOJ1644 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), index = 2, total = 0 , lo = 0, hi = 0, answer = 0;
        
        if(N == 1){
            System.out.println(0);
            System.exit(0);
        }else if(N <= 3){
            System.out.println(1);
            System.exit(0);
        }
        int[] arr = new int[N+1];
         arr[0] = 2; arr[1] = 3;
        for(int i = 4 ; i < N + 1 ; i++ ){
            boolean flag = true;
            for(int j = 2 ; j < Math.sqrt(i)+1 ; j++ ){
                if(i % j ==0 ){
                    flag = false;
                    break;
                }
            }
            if(flag){
                arr[index++] = i;
            }
        }
        while(true){
            if(total >= N) total -= arr[lo++];
            else if(hi == index +1) break;
            else total += arr[hi++];

            if(total == N) answer++;
        }
        
        System.out.println(answer);

    }
    
}
