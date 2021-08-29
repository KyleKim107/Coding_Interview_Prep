package Brute_Force;

import java.util.*;
import java.io.*;

public class SW1247 {
    public static int[][] arr;
    public static int[] com = new int[2], home = new int[2];
    public static int minV;

    public static int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void func(int depth, int[] visit, int curr, int x, int y) {
        if(curr > minV){return;}

        if (depth == arr.length) {
            minV = Math.min( minV , curr + manhattan(x, y, home[0], home[1]) );
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visit[i] == 1)
                continue;
            visit[i] = 1;
            func(depth + 1, visit, curr + manhattan(x, y, arr[i][0], arr[i][1]), arr[i][0], arr[i][1]);
            visit[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Brute_Force/SW1247.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            StringTokenizer str = new StringTokenizer(br.readLine());
            com[0] = Integer.parseInt(str.nextToken());
            com[1] = Integer.parseInt(str.nextToken());
            home[0] = Integer.parseInt(str.nextToken());
            home[1] = Integer.parseInt(str.nextToken());
            for (int i = 0; i < N; i++) {
                arr[i][0] = Integer.parseInt(str.nextToken());
                arr[i][1] = Integer.parseInt(str.nextToken());
            }
            minV = Integer.MAX_VALUE;
            func(0 , new int[N], 0 , com[0], com[1] );
            System.out.println(minV);
        }
    }
}
