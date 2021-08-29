package simulation;

import java.util.*;
import java.io.*;

public class BOJ2567 {
    public static void main(String[] args) {

        int g[][] = new int[102][102];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) { // 색칠하기
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    g[j][k] = 1;
                }
            }
        }
        for (int i = 1; i < 102; i++) {
            System.out.println(Arrays.toString(g[i]));
        }

        int count = 0;
        for (int i = 1; i < 102; i++) {
            for (int j = 1; j < 102; j++) {
                if (g[i][j] == 1) {
                    if (g[i - 1][j] == 0)
                        count++;
                    if (g[i + 1][j] == 0)
                        count++;
                    if (g[i][j - 1] == 0)
                        count++;
                    if (g[i][j + 1] == 0)
                        count++;
                }
            }
        }
        System.out.println(count);

    }
}
