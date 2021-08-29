package Graph.BFS;

import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.io.*;

public class BOJ10026 {
    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dx = { 1, -1, 0, 0 };
    public static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/BFS/BOJ10026.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            arr[i] = tmp.toCharArray();
        }
        boolean[][] visit = new boolean[N][N];
        int normal = 0;
        for (int i = 0; i < N; i++) { // 정상인
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    normal += 1;
                    visit[i][j] = true;
                    Queue<Node> Q = new LinkedList<>();
                    Q.offer(new Node(i, j));
                    while (!Q.isEmpty()) {
                        Node node = Q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = node.x + dx[dir];
                            int ny = node.y + dy[dir];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] == true
                                    || arr[nx][ny] != arr[i][j]) {
                                continue;
                            }
                            visit[nx][ny] = true;
                            Q.offer(new Node(nx, ny));
                        }
                    }
                }
            }
        }

        int adnormal = 0;
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) { // 정상인
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    adnormal += 1;
                    visit[i][j] = true;
                    Queue<Node> Q = new LinkedList<>();
                    Q.offer(new Node(i, j));
                    while (!Q.isEmpty()) {
                        Node node = Q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = node.x + dx[dir];
                            int ny = node.y + dy[dir];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] == true) {
                                continue;
                            }
                            if ( (arr[i][j] == 'B' && arr[nx][ny] == 'B' ) || ((arr[i][j] == 'R' && arr[nx][ny] != 'B'  ) ||  (arr[i][j] == 'G' && arr[nx][ny] != 'B'  ))) {
                                visit[nx][ny] = true;
                                Q.offer(new Node(nx, ny));
                            }
                        }
                    }
                }
            }
        }

        System.out.print(normal +" " + adnormal);
    }

}
