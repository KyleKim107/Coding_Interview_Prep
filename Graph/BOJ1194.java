package Graph;

import java.util.*;
import java.io.*;

public class BOJ1194 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int N, M, answer = -1; // N : row , M : column
    static boolean[][][] visited; // 방문 처리 할거
    static char[][] map; // 맵 생성
    static Queue<moon> queue;

    

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/BOJ1194.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken()); M = Integer.parseInt(str.nextToken());
        queue = new LinkedList<>();

        map = new char[N][M];
        // 각각 키를 가지고 있는 경우의 수를 배열로 처리하자.
        visited = new boolean[N][M][1 << 6];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == '0') {
                    startX = i;
                    startY = j;
                }

            }

        }

        queue.add(new moon(startX, startY, 0, 0));
        bfs();
        System.out.println(answer);
    }

    static public void bfs() {

        while (!queue.isEmpty()) {
            moon Node = queue.poll();

            if (map[Node.x][Node.y] == '1') { // 도착지점이라면
                answer = Node.dist;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = Node.x + dx[d];
                int ny = Node.y + dy[d];
                int flag = Node.flag;
                // System.out.println(flag);
                int count = Node.dist;

                // 범위 체크
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#' || visited[nx][ny][flag])
                    continue;

                // 키를 발견했을 때,
                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
                    visited[nx][ny][flag | 1 << map[nx][ny] - 'a'] = true;
                    queue.add(new moon(nx, ny, flag | 1 << map[nx][ny] - 'a', count + 1));
                }
                // 대문 발견했을 때,
                else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
                    if ((flag & (1 << map[nx][ny] - 'A')) > 0) { // 키를 가지고 있다면 0보다 크다
                        visited[nx][ny][flag] = true;
                        queue.add(new moon(nx, ny, flag, count + 1)); // 큐에 추가
                    }
                } else { // case '.'
                    visited[nx][ny][flag] = true;
                    queue.add(new moon(nx, ny, flag, count + 1));

                }

            }
        }
    }
    static class moon {
        int x,y,flag,dist;
        public moon(int x, int y, int flag, int dist) {
            this.x = x;
            this.y = y;
            this.flag = flag;
            this.dist = dist;
        }

    }
}
