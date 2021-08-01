package SWEA;
import java.util.*;

public class sw1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int[][][] tmp = new int[3][N][N];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        // 90
        for(int p = 0 ; p < 3 ; p++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    tmp[p][j][N -1 - i] = arr[i][j];
                }
            }
            arr = tmp[p];
        }
        // System.out.printf("%d\n", test_case);

            for(int i = 0 ; i < N ; i++){
                for(int p = 0 ; p < 3 ; p++){
                    for(int j = 0 ; j < N ; j++){
                        System.out.print(tmp[p][i][j]);
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }


        
    }
}
