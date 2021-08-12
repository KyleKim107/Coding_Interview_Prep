package simulation;

import java.util.*;
import java.io.*;

public class BO16926 {
    public static int[] dx = { 0, 1, 0, -1 }; // 오른 , 아래, 왼, 위
    public static int[] dy = { 1, 0, -1, 0 };
    public static int[][] arr;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        int R = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        int len = Math.min(N, M) / 2;
        for (int q = 0; q < R; q++) {
            for (int index = 0; index < len; index++) {
                int tmp = arr[index][index];
                int x = index, y = index;
                for (int dir = 0; dir < 4; dir++) {
                    while (true) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (index > nx || nx >= N - index || index > ny || ny >= M - index)
                            break;
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    }
                }
                arr[index + 1][index] = tmp;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }

    }
}
// 2 3 2
// 1 2 3
// 4 5 6

// 3 2 2
// 1 2
// 3 4
// 5 6

// 3 10 1
// 1 2 3 4 5 6 7 8 9 10
// 1 2 3 4 5 6 7 8 9 10
// 1 2 3 4 5 6 7 8 9 10
