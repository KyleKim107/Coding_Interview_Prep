package simulation;

import java.util.*;
import java.io.*;

public class BOJ2999 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ2999.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length(), x = -1, y = -1;
        for (int i = 1; i < N; i++) {
            for (int j = i; j <= N; j++) {
                if (i * j == N && i <= j) {
                    x = i;
                    y = j;
                }
            }
        }
        int strIndex = 0;
        char[][] charL = new char[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                charL[j][i] = str.charAt(strIndex++);
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(charL[i][j]);
            }
        }

    }

}
