package Graph.union_find;

import java.util.*;
import java.io.*;

public class BOJ1976ver2 {
    static int[] city;

    static int find(int x) {
        if (city[x] != x) {
            return city[x] = find(city[x]);
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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        city = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            city[i] = i;
        }

        StringTokenizer str = null;
        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(str.nextToken());
                if (tmp != 0) {
                    union(i, j);
                }
            }
        }

        str = new StringTokenizer(br.readLine());
        int goal = -1;
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(str.nextToken());
            if (goal == -1) {
                goal = find(tmp);
            }
            if (goal != find(tmp)) { // 패스 컴프레셔를 쓰면 더 깊은 뎁스의 노드는
                                     // 루트를 보지 않을 경우가 있기에 다시한번 find으로 재정의해준다
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
