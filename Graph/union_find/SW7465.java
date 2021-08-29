package Graph.union_find;

import java.util.*;
import java.io.*;

public class SW7465 {
    public static int[] arr;

    public static int find(int x) {
        if (arr[x] != x)
            return arr[x] = find(arr[x]);
        return x;
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y)
            arr[x] = y;
        else
            arr[y] = x;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/Union_Find/SW7465.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());
            arr = new int[N + 1];
            int[] check = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                arr[i] = i;
            }
            for (int i = 0; i < M; i++) {
                str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken()), y = Integer.parseInt(str.nextToken());
                union(x, y);
            }
            HashSet<Integer> set = new HashSet<>();
            int cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                int tmp = find(arr[i]);
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    cnt += 1;
                }
            }
            System.out.println("#" +test +" "+cnt);
        }

    }
}
