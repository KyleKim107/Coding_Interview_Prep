package Graph.BFS;

import java.util.*;
import java.io.*;

public class BOJ7576 {
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/BFS/BOJ7576.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken());
        int[][] arr = new int[M][N];
        Queue<Node> tomato = new LinkedList<Node>();
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                if (arr[i][j] == 1) {
                    tomato.offer(new Node(i, j));
                }
            }
        }
        int[][] visit = new int[M][N];
        int tomatoCnt = 0, cnt = 0;

        while (!tomato.isEmpty()) {
            int leng = tomato.size();
            for (int i = 0; i < leng; i++) {
                Node tmp = tomato.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = tmp.x + dx[dir];
                    int ny = tmp.y + dy[dir];
                    if (nx < 0 || nx >= M || ny < 0 || ny >= N)
                        continue;
                    if (visit[nx][ny] == 0 && arr[nx][ny] == 0) {
                        visit[nx][ny] = 1;
                        arr[nx][ny] = 1;
                        tomato.offer(new Node(nx,ny));
                        tomatoCnt++;
                    }
                }
            }
            
            cnt += tomatoCnt > 0 ? 1 : 0;
        }
       
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if(cnt == 0){
            System.out.println(0);
        }else{
            System.out.println(cnt-1);
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
