package simulation;

import java.util.*;

import java.io.*;
import java.lang.reflect.Array;

public class SW_Processor {
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static int[][] arr;
    public static int N, maxCore, minLen;
    public static ArrayList<Node> chip ;

    public static boolean validate(int x, int y, int dir) {
        int nx = x, ny = y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                return true;
            if (arr[nx][ny] >= 1)
                return false;
        }
    }

    public static void func(int index, int core, int total) {
        if (index == chip.size()) {
            if (maxCore < core) {
                maxCore = core;
                minLen = total;
            } else if (maxCore == core) {
                minLen = Math.min(minLen, total);
            }
            return;
        }
        Node tmp = chip.get(index);
        for (int dir = 0; dir < 4; dir++) {
            if (validate(tmp.x, tmp.y, dir)) {
                func(index + 1, core + 1, total + markErase(tmp.x, tmp.y, dir, 2));
                markErase(tmp.x, tmp.y, dir, 0);
            }
        }
    }

    public static int markErase(int x, int y, int dir, int status) {
        int nx = x, ny = y, cnt = 0;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                return cnt;
            arr[nx][ny] = status;
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/SW_Processor.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer str = null;
        for (int test = 1; test <= TC; test++) {
            N = Integer.parseInt(br.readLine());
            maxCore = 0;
            minLen = Integer.MAX_VALUE;
            chip = new ArrayList<Node>();
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                str = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());
                    if (i == 0 || j == 0 || i == N - 1 || j == N - 1 || arr[i][j] == 0)
                        continue;
                    chip.add(new Node(i, j));
                }
            }
            func(0, 0, 0);
            System.out.println("#" + test + " "+minLen);
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
