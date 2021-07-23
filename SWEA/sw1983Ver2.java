package SWEA;

import java.util.*;

public class sw1983Ver2 {
    public static void main(String[] args) {
        int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

        // System.setIn(new FileInputStream('input.txt'));
        

        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int test = 1; test <= TC; test++) {
            int N = sc.nextInt();
            
            char[][] grid = new char[N][N];
            int[][] tall = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                grid[i][j] = sc.next().charAt(0);
                }
            }

            int max = 0;
            int premax = 0;
            for (int r = 0; r < N; r++)
                for (int c = 0; c < N; c++)
                    if (grid[r][c] == 'B') {
                        boolean flag = false;
                        for (int d = 0; d < 8; d++) {
                            int nr = r + deltas[d][0];
                            int nc = c + deltas[d][1];
                            if ( nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                if( grid[nr][nc] == 'G'){
                                    tall[r][c] = 2;
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        int cnt = 0;
                        if(!flag){
                            for(int i = 0 ; i < N ; i++){
                                if(grid[r][i] == 'B') cnt += 1;
                                if(grid[i][c] == 'B') cnt += 1;
                            }
                            if(grid[r][c] == 'B') cnt -= 1;
                        }
                        premax =  Math.max(cnt , tall[r][c]);
                        max = Math.max(max , premax);
                    }
            // END:
            System.out.printf("#%d %d%n",test , max);
        }
    }
}
