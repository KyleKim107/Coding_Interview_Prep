package simulation;

import java.util.*;
import java.io.*;

public class BOJ14502 {
    public static int[][] arr;
    public static int N, M, maxV = Integer.MIN_VALUE;
    public static ArrayList<Node> space = new ArrayList<Node>(), virus = new ArrayList<Node>();;
    public static int[] dx = { 1, -1, 0, 0 };
    public static int[] dy = { 0, 0, 1, -1 };

    public static void func(int total, int index, Node[] pick) {
        if (total == 3) {
            int[][] map = new int[N][M];
            for (int i = 0; i < N; i++) {
                map[i] = Arrays.copyOf(arr[i], M);
            }
            maxV = Math.max(maxV, blocking(pick, map));
            return;
        }
        if (total > 3 || index >= space.size())
            return;

        func(total, index + 1, pick);
        pick[total] = space.get(index);
        func(total + 1, index + 1, pick);

    }

    public static int blocking(Node[] pick, int[][] copyMap) {
        for (int i = 0; i < 3; i++) {
            Node tmp = pick[i];
            copyMap[tmp.x][tmp.y] = 1; // 벽을 세운다
        }

        for (int i = 0; i < virus.size(); i++) {
            Node vir = virus.get(i);
            Queue<Node> Q = new LinkedList<>();
            int[][] visit = new int[N][M];
            visit[vir.x][vir.y] = 1;
            Q.offer(vir);
            while (!Q.isEmpty()) {
                Node next = Q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = next.x + dx[dir];
                    int ny = next.y + dy[dir];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                        continue;
                    if (visit[nx][ny] == 0 && copyMap[nx][ny] == 0) {
                        visit[nx][ny] = 1;
                        copyMap[nx][ny] = 2;
                        Q.offer(new Node(nx, ny));
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cnt += copyMap[i][j] == 0 ? 1 : 0;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ14502.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                if (arr[i][j] == 0) {
                    space.add(new Node(i, j));
                } else if (arr[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }
        // 세가지를 뽑고
        func(0, 0, new Node[3]);
        System.out.println(maxV);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
