package simulation;

import java.util.*;
import java.io.*;

public class BOJ17135 {
    public static int N, M, D, enermy, maxV = Integer.MIN_VALUE;
    public static int[] archer;
    public static int[][] arr;
    public static int[][] tmpArr;
    // public static int[][] ArchersPos;

    public static boolean dist(int monX, int monY, int archerX, int archerY,int currD) {
        int value = Math.abs(monX - archerX) + Math.abs(monY - archerY);
        return ((value <= currD) ? true : false);
    }

    public static void move() {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (tmpArr[i][j] == 1) {
                    if (i + 1 < N) {
                        tmpArr[i][j] = 0;
                        tmpArr[i + 1][j] = 1;
                    } else {
                        tmpArr[i][j] = 0;//그냥 없애기
                    }
                }
            }
        }
    }

    public static void simulation(int[] Archers, int[] ArcherPos) {
        tmpArr = new int[N][M];
        int enermy = 0;
        for (int i = 0; i < N; i++) {
            tmpArr[i] = Arrays.copyOf(arr[i], arr[i].length);

        } 
        // End of copying arr
        //   System.out.println("궁수들 ");
        //   System.out.println(Arrays.toString(Archers));
        //   System.out.println();
        int kill = 0;int turn = 0; int currD = D;
        while (true) {
            // attack
            for (int ArcherNum = 0; ArcherNum < 3; ArcherNum++) {
                int archCol = ArcherPos[ArcherNum];
               outter: for (int i = N - 1 ; i > N - 1 - currD; i--) {
                            for (int j = 0; j < M; j++) {
                                if (tmpArr[i][j] == 1 && dist(i, j, N, archCol, currD)) {
                                    tmpArr[i][j] = 0;
                                    kill += 1;
                                    break outter;
                                }

                            }
                    }
            } //end of attack
            currD+= 1;
            // System.out.println("Kill " + kill  + " D "+ D);

            
            // for (int i = 0; i < N; i++) {
            //   // for (int j = 0; j < M ; j++) {
            //   System.out.println(Arrays.toString(tmpArr[i]));
            //   }
            //   System.out.println();
              if(++turn == N){
                  break;
              }
            
        }
        maxV = Math.max(maxV, kill);
    }

    public static void func(int depth, int[] visit, int[] curr) {
        if (depth == M) {
            int[] archerPos = new int[3];
            int index = 0;
            for (int i = 0; i < M; i++) {
                if (curr[i] == 1) {
                    archerPos[index++] = i;
                }
            }
            simulation(curr, archerPos); // simulation
            return;
        }
        for (int i = 0; i < M; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                curr[depth] = archer[i];
                func(depth + 1, visit, curr);
                curr[depth] = 0;
                visit[i] = 0;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ17135.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        D = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        
        archer = new int[M];
        archer[0] = 1;
        archer[1] = 1;
        archer[2] = 1;

        func(0, new int[M], new int[M]);
        System.out.println(maxV);

    } // end of main
}
