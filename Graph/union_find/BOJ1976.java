package Graph.union_find;

import java.util.*;
import java.io.*;

public class BOJ1976 {
    static int[] city;

    static int find(int x) {
        if (city[x] != x) {
            return city[x] =find(city[x]);
        }
        return x;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) {
            city[x] = y;
        } else {
            city[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/union_find/BOJ1976.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        StringTokenizer str = null;
        city = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            city[i] = i;
        }
        // System.out.println(Arrays.toString(city));
        // System.out.println(Arrays.toString(course));
        for (int i = 1; i < N + 1; i++) {
            System.out.println(" i :" + i);
            str = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int tmp = Integer.parseInt(str.nextToken());
                if (j > i && tmp != 0) {
                    union(i, j);
                }
            }
            System.out.println(Arrays.toString(city));
        }
        str = new StringTokenizer(br.readLine());
        int first = -1;
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(str.nextToken());
            if (first == -1) {
                first = find(tmp);
            }
            if (first != find(tmp)) {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");

    }

}
