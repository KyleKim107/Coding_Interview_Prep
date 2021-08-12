package simulation;
import java.util.*;


import java.io.*;

public class BOJ2563 {
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        board = new int[100][100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = null;
        for(int z = 0 ; z < N ; z++){
            str = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(str.nextToken()) - 1, x  = Integer.parseInt(str.nextToken()) - 1;
            for(int i = 0 ; i < 10 ; i++ ){
                for(int j = 0 ; j < 10 ; j++ ){
                    if( 0 <= (x +i) &&  (x +i) < 100 && 0 <= (y +j) && (y +j)< 100 ){
                        board[x +i][y +j ] += 1 ;
                    }
                }
            }
        }
        int cnt = 0;
            for(int i = 0 ; i < 100 ; i++ ){
                for(int j = 0 ; j < 100 ; j++ ){
                    if(board[i][j] > 0){
                        cnt += 1;
                    }
                }
            }
        System.out.println(cnt);
    }
}
