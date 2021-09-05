package simulation;

import java.util.*;

import java.io.*;

public class SW1954 {
    public static int[] dx = { 0, 1, 0, -1 };
    public static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/SW1954.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int v = 1;
            int row = N, x = 0, y = 0, ver = 0;
            while (v <= N * N) {
                arr[x][y] = v++;
                if (row <= 1) {
                    break;
                }
                for (int dir = 0; dir < 4; dir++) {
                    for (int z = 0; z < row - 1; z++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (nx < ver || nx >= row + ver || ny < ver || ny >= row + ver) {
                            break;
                        }
                        arr[nx][ny] = v++;
                        x = nx;
                        y = ny;
                    }
                    if (dir == 2) {
                        row -= 1;
                    }

                }
                row -= 1;
                ver++;
                y += 1;
            }
            System.out.println("#" + test);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

}
