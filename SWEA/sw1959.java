package SWEA;
import java.util.*;

public class sw1959 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();int M = sc.nextInt();
        int[] a = new int[N];  int[] b = new int[M];
        for(int i = 0 ; i < N; i ++){
            a[i] = sc.nextInt();
        }
        for(int i = 0 ; i < M; i ++){
            b[i] = sc.nextInt();
        }
        int cnt = 0;
        int maxV = 0;
        if(N > M){
            for(int i = 0 ; i < N - M+1; i ++){
                for(int j = 0 ; j < M ; j ++){
                    cnt +=  (a[i+j]*b[j]);
                }
                maxV = Math.max(maxV, cnt);
                cnt = 0;
            }
        }else{
            for(int i = 0 ; i < M - N+1; i ++){
                for(int j = 0 ; j < N ; j ++){
                    cnt +=  (a[j]*b[i+j]);
                }
                maxV = Math.max(maxV, cnt);
                cnt = 0;
            }
        }
        System.out.println(maxV);


    }
    
}
