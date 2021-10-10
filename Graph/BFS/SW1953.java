package Graph.BFS;

import java.util.*;
import java.io.*;

public class SW1953 {
    public static int[] dx = { -1, 0, 1, 0 };// 상 우 하 좌
    public static int[] dy = { 0, 1, 0, -1 };
    public static int[][] pipDIR = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
    public static int[][][] availableTo = { {}, 
    {{1,2,5,6},{1,3,6,7},{1,2,4,7},{1,3,4,5}}, // 1
     { { 1,2, 5, 6 }, {}, { 1,2, 4, 7 }, {} }, // 2
            { {}, { 1,3,6, 7 }, {}, { 1,3, 4,5 } }, // 3
            { { 1, 2, 5, 6 }, { 1, 3, 6, 7 }, {}, {} }, // 4
            { {}, { 1, 3, 6, 7 }, { 1, 2, 4, 7 }, {} }, // 5
            { {}, {}, { 1, 2, 4, 7 }, { 1, 3, 4, 5 } }, // 6
            { { 1, 2, 5, 6 }, {}, {}, { 1, 3, 4, 5 } } // 7
    };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/BFS/SW1953.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken()),
                    startX = Integer.parseInt(str.nextToken()), startY = Integer.parseInt(str.nextToken()),
                    time = Integer.parseInt(str.nextToken());
            int[][] arr = new int[N][M];
            int[][] visit = new int[N][M];
            for (int i = 0; i < N; i++) {
                str = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());
                }
            }

            Queue<Node> Q = new LinkedList<>();
            Q.offer(new Node(startX, startY));
            visit[startX][startY] = 1;
            int cnt = 0;
            while (time-- > 0) {
                int leng = Q.size();
                for (int i = 0; i < leng; i++) {
                    Node tmp = Q.poll();
                    cnt++;
                    int X = tmp.x, Y = tmp.y;
                    for (int dir = 0; dir < pipDIR[arr[X][Y]].length; dir++) {
                        int nextDir = pipDIR[arr[X][Y]][dir];
                        int nx = X + dx[nextDir];
                        int ny = Y + dy[nextDir];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                            continue;
                        if (visit[nx][ny] == 0 && arr[nx][ny] > 0) {
                            for (int z = 0; z < availableTo[arr[X][Y]][nextDir].length; z++) {
                                if (availableTo[arr[X][Y]][nextDir][z] == arr[nx][ny]) {
                                    visit[nx][ny] = visit[X][Y] + 1;
                                    Q.offer(new Node(nx, ny));
                                    break;
                                }
                            }
                    
                        }
                    }
                }
            }
            System.out.println("#" + test + " " + cnt);

        }

    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
