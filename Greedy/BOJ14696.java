package Greedy;

import java.util.*;
import java.io.*;

public class BOJ14696 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Greedy/BOJ14696.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = null, b = null;
        StringTokenizer str = null;
        for (int z = 0; z < N; z++) {
            str = new StringTokenizer(br.readLine());
            int aN = Integer.parseInt(str.nextToken());
            a = new int[aN];
            int[] aL = new int[5];
            for (int i = 0; i < aN; i++) {
                a[i] = Integer.parseInt(str.nextToken());
                aL[a[i]]++;
            }

            str = new StringTokenizer(br.readLine());
            int bN = Integer.parseInt(str.nextToken());
            int[] bL = new int[5];
            b = new int[bN];
            for (int i = 0; i < bN; i++) {
                b[i] = Integer.parseInt(str.nextToken());
                bL[b[i]]++;
            }

            int flag = -1;
            outter: for (int num = 4; num >= 1; num--) {

                if (aL[num] > bL[num]) {
                    flag = 1;
                    break outter;
                } else if (aL[num] < bL[num]) {
                    flag = 2;
                    break outter;
                }
            }
            if (flag == -1) {
                System.out.println("D");
            } else {
                System.out.println(((flag == 1) ? "A" : "B"));
            }

        }
    }
}


