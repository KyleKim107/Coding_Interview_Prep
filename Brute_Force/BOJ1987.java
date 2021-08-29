package Brute_Force;

import java.util.*;
import java.io.*;

public class BOJ1987 {
    public static int N, M, maxV = Integer.MIN_VALUE;
    public static int[] dx = { -1,1, 0, 0}, dy = { 0, 0, -1, 1};
    public static char[][] arr;
    public static int[][] visit;

    public static void func(int x, int y, int steps, int[] set) {
        System.out.println(Arrays.toString(set));
        maxV = Math.max(maxV, steps);
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M ||set[arr[nx][ny] - 'A'] == 1){
                continue;
            }
            set[arr[nx][ny] - 'A'] = 1;
            func(nx, ny, steps + 1, set);
            set[arr[nx][ny] - 'A'] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Brute_Force/BOJ1987.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken()); M = Integer.parseInt(str.nextToken());
        arr = new char[N][M]; visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            arr[i] = tmp.toCharArray();
        }
        int[] set = new int[26];
        set[arr[0][0] - 'A'] = 1;
        func(0, 0, 1, set);
        System.out.println(maxV);
    }
}
