package Dynamic_Programming.Floyd;

import java.util.*;
import java.io.*;

public class SW5643 {
    final static int maxV = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = pint(st.nextToken());
        int m = pint(st.nextToken());
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], maxV);
        }
        // 방향 그래프
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = pint(st.nextToken()) - 1;
            int b = pint(st.nextToken()) - 1;
            adj[s][b] = 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(adj[i]));
        }
        System.out.println();
        // 플로이드
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (k != i && k != j && i != j) {
                        // System.out.println(" i : " + i + " k :" + k + " j : " + j);
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(adj[i]));
        }
        // 조건을 만족하는 학생 카운트
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            adj[i][i] = 0;
            boolean chk = true;
            for (int j = 0; j < n; j++) {
                if (Math.min(adj[i][j], adj[j][i]) == maxV) {
                    chk = false;
                    break;
                }
            }
            if (chk)
                cnt++;
        }

        System.out.println(cnt);
    }

    static int pint(String s) {
        return Integer.parseInt(s);
    }
}

// 1
// 6
// 6
// 1 5
// 3 4
// 5 4
// 4 2
// 4 6
// 5 2