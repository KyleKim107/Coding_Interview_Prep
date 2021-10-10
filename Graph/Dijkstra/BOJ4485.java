package Graph.Dijkstra;

import java.util.*;
import java.io.*;

public class BOJ4485 {
    public static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    public static int N, INFINITY = Integer.MAX_VALUE;;
    public static int[][] arr, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            arr = new int[N][N];
            dist = new int[N][N];// visit대신 dist!
            for (int i = 0; i < N; i++) { // 배열을 초기화 하고 거리는 infinity로 초기화
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());
                    dist[i][j] = INFINITY;
                }
            }
            System.out.println("Problem " + (++test) + ": " + func());
        }
    }

    static int func() {
        PriorityQueue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(0, 0, arr[0][0]));
        dist[0][0] = arr[0][0];
        while (!Q.isEmpty()) {
            Node tmp = Q.poll(); // 하나를 뽑는다
            int x = tmp.x;
            int y = tmp.y;
            for (int i = 0; i < 4; i++) { // 4방탐색
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) { // 범위 설정
                    if (dist[nx][ny] > dist[x][y] + arr[nx][ny]) { // 현재 위치의 거리와 다음 노드까지의 거리의 거리 비교
                                                                 //  다른 노드에서 접근해 더 작다면 
                        dist[nx][ny] = dist[x][y] + arr[nx][ny];
                        Q.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }
        return dist[N - 1][N - 1];
    }

    static class Node implements Comparable<Node> {
        int x, y, val;

        public Node(int r, int c, int val) {
            this.x = r;
            this.y = c;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }
    }
}
