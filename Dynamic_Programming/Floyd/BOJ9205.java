package Dynamic_Programming.Floyd;

import java.util.*;
import java.io.*;

public class BOJ9205 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Dynamic_Programming/Floyd/BOJ9205.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = null;
        for (int test = 1; test <= N; test++) {
            int beer = Integer.parseInt(br.readLine());
            int[][] path = new int[beer + 2][beer + 2], arr = new int[beer + 2][2];
            for (int i = 0; i < beer + 2; i++) {
                str = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(str.nextToken());
                arr[i][1] = Integer.parseInt(str.nextToken());
            }
            for (int i = 0; i < beer + 2; i++) {
                for (int j = 0; j < beer + 2; j++) {
                    if (i == j)
                        continue;
                    if (Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]) <= 1000) {
                        path[i][j] = path[j][i] = 1;
                    }
                }
            }

            for (int mid = 0; mid < beer + 2; mid++) {
                for (int i = 0; i < beer + 2; i++) {
                    if (mid == i)
                        continue;
                    for (int j = 0; j < beer + 2; j++) {
                        if (mid == j || i == j)
                            continue;
                        if (path[i][mid] == 1 && path[mid][j] == 1) {
                            path[i][j] = 1;
                        }
                    }
                }
            }

            System.out.println(path[0][beer + 1] == 1 ? "happy" : "sad");
        }
    }

}
