package simulation;

import java.util.*;
import java.io.*;

public class SW7236 {
    public static int[] dx = { 1, 1, -1, 0, 0, -1, -1, 1 };
    public static int[] dy = { 1, 0, 0, 1, -1, -1, 1, -1 };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/SW7236.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            int N = Integer.parseInt(br.readLine()), maxV = Integer.MIN_VALUE;
            char[][] arr = new char[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().replace(" ", "").toCharArray();
                // System.out.println(Arrays.toString(arr[i]));
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 'W') {
                        // System.out.println("i " + i + " j " + j);
                        int w = 0, g = 0;
                        for (int dir = 0; dir < 8; dir++) {
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                                continue;
                            if (arr[nx][ny] == 'W') {
                                w++;
                            } else {
                                g++;
                            }
                        }
                        if (g == 8)
                            w = 1;
                        maxV = Math.max(maxV, w);
                    }
                }
            }
            System.out.println("#" + test + " " + maxV);
        }

    }
}
