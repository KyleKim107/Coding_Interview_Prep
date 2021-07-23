package SWEA;
import java.util.*;
public class sw2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] a = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j =0 ; j < N ; j++){
                a[i][j] = sc.nextInt();
            }
            // System.out.println(Arrays.toString(a[i]));
        }
        int max =-9999;
        int cnt = 0;
        for(int i = 0 ; i < N-M+1 ; i++){
            for(int j =0 ; j < N-M+1 ; j++){
                System.out.printf("%d%d\n" ,i, j );
                for(int k = 0 ; k < M; k++){
                    for(int l = 0 ; l < M; l++){
                            cnt += a[i+k][j+l] ;
                    }
                }
                max = Math.max(max , cnt);
                cnt = 0;
            }
        }
        System.out.println(max);

    }
    
}
