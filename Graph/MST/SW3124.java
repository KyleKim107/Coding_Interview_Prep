package Graph.MST;
import java.util.*;
import java.io.*;

public class SW3124 {
    public static int[] arr;

    static int find(int x) {
        if (arr[x] != x) {
            return arr[x] = find(arr[x]);
        }
        return x;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if ( x > y) {
            arr[x] = y;
        } else {
            arr[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {

            StringTokenizer str = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(str.nextToken()), E = Integer.parseInt(str.nextToken());
            arr = new int[V + 1];
            for (int i = 1; i < V + 1; i++) {
                arr[i] = i;
            }
            PriorityQueue<Node> PQ = new PriorityQueue<Node>();
            for (int i = 0; i < E; i++) {
                str = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(str.nextToken()), end = Integer.parseInt(str.nextToken()),
                        value = Integer.parseInt(str.nextToken());
                PQ.offer(new Node(start, end, value));
            }
            
            long answer = 0;
            for (int i = 0; i < PQ.size(); i++) {
                Node tmp = PQ.poll();
                int start = tmp.start, end = tmp.end, value = tmp.value;
                if (find(start) == find(end))
                    continue;
                union(start, end);
                answer += value;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static class Node implements Comparable<Node> {
        int value, end, start;

        public Node(int start, int end, int value) {
            super();
            this.value = value;
            this.end = end;
            this.start = start;
        }

        @Override
        public int compareTo(Node a) { // compareTo는 상대꺼만, compare은 둘다
            return Integer.compare(this.value , a.value);
        }
    }

}
// for (Node tmp : PQ) {
//     System.out.println(" tmp.start : " + tmp.start + " tmp.end : " + tmp.end + " tmp.value : " + tmp.value);
// }
