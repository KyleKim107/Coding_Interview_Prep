package simulation;

import java.util.*;
import java.io.*;

public class BOJ16236 {
    /**
     * 백준 아기 상어 N X N 크기의 맵. M마리의 물고기와 아기 상어 1마리. 아기 상어 크기 : 2, 사방 이동 자신의 크기보다 큰
     * 물고기가 있는 칸은 갈 수 없음. 자기보다 작은 물고기는 먹을 수 있음. 같은 물고기는 지날 수는 있지만 먹지는 못함. 먹을 수 있는
     * 물고기가 1마리라면 그 물고기 먹으러 가고 1마리 초과면 가까운 물고기 먹으러 간다. 거리 : 지나는 칸의 개수 거리마저 같다면 가장 위에
     * 있는 물고기 그것 마저 같으면 가장 왼쪽에 있는 물고기를 먹는다.
     * 
     * 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기 1 증가한다. 크기 2는 2마리 먹어야 증가한다. 먹을 수 있는 물고기 없으면 엄마에게
     * 도움 요청, 시뮬 종료. 몇초 동안 도움 요청 안하고 먹을 수 있나? = 몇초가 지나면 먹을 물고기가 없어지나?
     * 
     * @param args
     * @throws Exception
     */
    static int N;
    static int[][] map;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    static int x, y, size = 2;
    static int answer;

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int time;

        public Fish(int x, int y, int time) {
            super();
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.time != o.time) {
                return Integer.compare(this.time, o.time); // 시간 오름차순
            } else {
                if (this.x != o.x) {
                    return Integer.compare(this.x, o.x); // 행 오름차순 (위쪽부터)
                } else {
                    return Integer.compare(this.y, o.y); // 열 오름차순 (왼쪽부터)
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 맵 크기
        map = new int[N][N]; // 맵

        // 0 : 빈칸, 1~6 : 칸에 있는 물고기 크기, 9 : 아기상어 위치
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    x = i; // 아기 상어의 행 좌표
                    y = j; // 아기 상어의 열 좌표
                    map[i][j] = 0;
                }
            }
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        int cnt = 0; // 물고기 먹은 수
        while (true) {
            List<Fish> fishes = new ArrayList<>();
            boolean[][] visited = new boolean[N][N];
            Queue<Fish> queue = new LinkedList<>();
            queue.offer(new Fish(x, y, 0)); // 아기 상어 시작 위치, time : 0
            visited[x][y] = true;

            while (!queue.isEmpty()) {
                Fish fish = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = fish.x + dx[i];
                    int ny = fish.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > size)
                        continue;

                    if (map[nx][ny] != 0 && map[nx][ny] < size) {
                        // 먹이감이 될 수 있는 물고기가 있다면
                        visited[nx][ny] = true;
                        queue.offer(new Fish(nx, ny, fish.time + 1));
                        fishes.add(new Fish(nx, ny, fish.time + 1));
                    }

                    // 사이즈가 같거나 빈 칸이라면 이동만 가능
                    queue.offer(new Fish(nx, ny, fish.time + 1));
                    visited[nx][ny] = true;

                }
            }

            if (fishes.isEmpty()) {
                return;
            } else {
                Collections.sort(fishes);
                System.out.println( "fishes.x :" +fishes.get(0).x + " fishes.y :" + fishes.get(0).y );

                Fish feed = fishes.get(0);

                x = feed.x;
                y = feed.y;

                map[x][y] = 0;
                answer += feed.time;

                cnt++;
                if (cnt == size) {
                    size += 1;
                    cnt = 0;
                }
            }
        }
    }

}
