package simulation;

import java.util.*;

import java.io.*;

public class BOJ16927 {
    // private static int[] dx = { 0, 1, 0, -1 };
    // private static int[] dy = { 1, 0, -1, 0 };
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ16927.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken()),
                R = Integer.parseInt(str.nextToken());
        System.out.println(N + " " + M + " " + R);
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        System.out.println("original");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
        int len = Math.min(N, M) / 2;
        for (int r = 0; r < R; r++) {
            for (int index = 0; index < len; index++) {
                int tmp = arr[index][index];
                int x = index;
                int y = index;
                for (int dir = 0; dir < 4; dir++) {
                    while (true) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (index > nx || nx >= (N - index) || index > ny || ny >= (M - index)) {
                            break;
                        }
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    }
                }
                arr[index ][index + 1] = tmp;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
