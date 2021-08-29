package simulation;

import java.util.*;
import java.io.*;

public class BOJ15683 {
    public static int[][] arr, camARR = new int[8][2];;
    public static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
    public static int[] rotate = { 0, 1, 2, 2, 3, 4 }; // 0(Dummy) 1 ,2 ,3, 4,5 cameras
    public static int[][] turn = { { 0 }, { 0 }, { 0, 2 }, { 0, 1 }, { 0, 1, 1 }, { 0, 1, 1, 1 } }; // 0 1 ,2 ,3, 4,5번
                                                                                                    // 카메라
    public static int[] cases = { 0, 1, 2, 3 };
    public static int N, M, camNum = 0, minV = Integer.MAX_VALUE, wall = 0;

    public static int rotate(int[] curr) {
        int[][] visit = new int[N][M];
        int cnt = 0;
        for (int i = 0; i < camNum; i++) {
            int x = camARR[i][0], y = camARR[i][1];
            int type = arr[x][y];
            int dir = curr[i];
            for (int turnN = 0; turnN < rotate[type]; turnN++) {
                dir = (dir + turn[type][turnN]) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (0 <= nx && nx < N && 0 <= ny && ny < M && arr[nx][ny] != 6) {
                    if (arr[nx][ny] == 0 && visit[nx][ny] == 0) {
                        visit[nx][ny] = 1;
                        cnt += 1;
                    }
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }

        }
        return cnt;
    }

    public static void func(int depth, int[] curr) {
        if (depth == camNum) {
            minV = Math.min(minV, N * M - rotate(curr) - camNum - wall);
            return;
        }
        for (int i = 0; i < cases.length; i++) {
            curr[depth] = cases[i];
            func(depth + 1, curr);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ15683.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(str.nextToken());
                arr[i][j] = tmp;
                if (0 < tmp && tmp < 6) {
                    camARR[camNum][0] = i;
                    camARR[camNum][1] = j;
                    camNum++;
                } else if (tmp == 6) {
                    wall++;
                }
            }
        }
        func(0, new int[camNum]);
        System.out.println(minV);
    }

}
