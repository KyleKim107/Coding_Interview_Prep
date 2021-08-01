package SWEA;
import java.util.*;

public class saltbug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] jump = {3,2,1};
        int[] dx = {-1, 1 , 0 ,0};
        int[] dy = {0, 0 , -1 , 1};
        int N = sc.nextInt();int M = sc.nextInt();
        int result = M;
        int[][] arr = new int[N][N];
        int[][] sal  = new int[M][4];
        for(int i = 0 ; i < M ; i++){
            sal[i][0]=sc.nextInt();
            sal[i][1]=sc.nextInt();
            sal[i][2]=sc.nextInt();
            sal[i][3]=1;
            arr[sal[i][0]][sal[i][1]] = sal[i][2];
            // System.out.println(Arrays.toString(sal[i]));
        }
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < M ; j ++){
                if (sal[j][3] == 0) continue;
                arr[sal[j][0]][sal[j][1]] = 0;
                int nx = dx[sal[j][2]] + sal[j][0];
                int ny = dx[sal[j][2]] + sal[j][1];
                if( nx < 0 || nx >= N || ny < 0 || ny >= N ){
                    sal[j][3] = 0;
                    result -= 1;
                    continue;
                }
                if (arr[nx][ny] > 0){
                    sal[j][3] = 0;
                    result -= 1;
                    continue;
                }
                sal[j][0] = nx;
                sal[j][1] = ny;
            }
        }
// 9 5
// 6 2 4
// 1 5 2
// 0 0 4
// 6 6 1
// 2 4 3
    }
    
}
