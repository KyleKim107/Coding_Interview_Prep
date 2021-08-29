package Graph;

import java.io.*;
import java.util.*;

public class Union_Find {
    public static int[] parent;

    public static int path_compresstion(int x) {
        if (parent[x] != x)
            return parent[x] = path_compresstion(parent[x]);
        // 부모테이블에 저장한다
        return x;
    }

    public static int find_parent(int x) {
        if (parent[x] != x) // 자기 자신이 루트인것을 찾자
            return find_parent(parent[x]);
        // 부모테이블에 따로 저장은 안해서 부모테이블에 변화는 없다.
        return x;
    }

    public static void union_parent(int x, int y) {
        x = find_parent(x);
        y = find_parent(y);
        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/Union_Find.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(str.nextToken()), E = Integer.parseInt(str.nextToken());
        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken()), y = Integer.parseInt(str.nextToken());
            union_parent(x, y);
        }

        // # 각 원소가 속한 집합 출력하기
        for (int i = 1; i < V + 1; i++) {
            System.out.print(path_compresstion(i) + " ");
        }
        // 출력:1 1 1 1 5 5
        System.out.println();

        // # 부모 테이블 내용 출력하기
        for (int i = 1; i < V + 1; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
