package simulation;

import java.util.*;
import java.io.*;

public class BOJ16935 {
    public static int[][] arr;
    public static int N, M, R;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ16935.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        R = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        str = new StringTokenizer(br.readLine());
        for (int a = 0; a < R; a++) {
            int order = Integer.parseInt(str.nextToken());
            if (order == 1) {
                int[][] tmp = new int[arr.length][arr[0].length];

                for (int j = 0; j < arr.length; j++) {
                    tmp[arr.length - 1 - j] = Arrays.copyOf(arr[j], arr[j].length);
                }
                arr = tmp;
            } else if (order == 2) {
                for(int r = 0 ; r < arr.length ; ++r) {
                    for(int c1 = 0, c2 = arr[0].length - 1 ; c1 < c2 ; c1++, c2--) {
                        int temp = arr[r][c1];
                        arr[r][c1] = arr[r][c2];
                        arr[r][c2] = temp;
                    }
                }
            } else if (order == 3) {
                int[][] tmp = new int[arr[0].length][arr.length];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        tmp[j][arr.length - i - 1] = arr[i][j];
                    }
                }
                arr = tmp;
                
            } else if (order == 4) {
                int[][] tmp = new int[arr[0].length][arr.length];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[0].length; j++) {
                        tmp[arr[0].length - 1 - j][i] = arr[i][j];
                    }
                }
                arr = tmp;
                
            } else if (order == 5) {
                int[][] tmp = new int[arr.length][arr[0].length];
		
                int rowLen = arr.length;
                int colLen = arr[0].length;
                
                for(int r = 0 ; r < rowLen / 2 ; ++r) { //1 -> 2
                    for(int c = 0 ; c < colLen / 2 ; ++c) {
                        tmp[r][c + colLen / 2] = arr[r][c];
                    }
                }
                
                for(int r = 0 ; r < rowLen / 2 ; ++r) {//2 -> 3
                    for(int c = colLen / 2 ; c < colLen ; ++c) {
                        tmp[r + rowLen / 2][c] = arr[r][c];
                    }
                }
                
                for(int r = rowLen / 2 ; r < rowLen ; ++r) {//3 -> 4
                    for(int c = colLen / 2 ; c < colLen ; ++c) {
                        tmp[r][c - colLen / 2] = arr[r][c];
                    }
                }
                for(int r = rowLen / 2 ; r < rowLen ; ++r) { // 4 -> 1
                    for(int c = 0 ; c < colLen / 2 ; ++c) {
                        tmp[r - rowLen / 2][c] = arr[r][c];
                    }
                }
                arr = tmp;
            }else if(order == 6){
                int[][] tmp = new int[arr.length][arr[0].length];
		
            int rowLen = arr.length;
            int colLen = arr[0].length;
            
            for(int r = 0 ; r < rowLen / 2 ; ++r) {
                for(int c = 0 ; c < colLen / 2 ; ++c) {
                    tmp[r + rowLen / 2][c] = arr[r][c];
                }
            }
            
            for(int r = rowLen / 2 ; r < rowLen ; ++r) {
                for(int c = 0 ; c < colLen / 2 ; ++c) {
                    tmp[r][c + colLen / 2] = arr[r][c];
                }
            }
            
            for(int r = rowLen / 2 ; r < rowLen ; ++r) {
                for(int c = colLen / 2 ; c < colLen ; ++c) {
                    tmp[r - rowLen / 2][c] = arr[r][c];
                }
            }
            
            for(int r = 0 ; r < rowLen / 2 ; ++r) {
                for(int c = colLen / 2 ; c < colLen ; ++c) {
                    tmp[r][c - colLen / 2] = arr[r][c];
                }
            }
            
            arr = tmp;

            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
              System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
