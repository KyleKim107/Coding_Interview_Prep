package simulation;
import java.util.*;
import java.io.*;

public class BOJ2636 {
    public static int[] dx = { 1, -1, 0, 0 };
    public static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ2636.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken());
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            arr[i] = tmp.replace(" ", "").toCharArray();
        }
        int time = 0, prev = 0;
        while (true) {
            int cnt = 0;
            OUTTER : for (int i = 1; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (arr[i][j] == '1')
                            continue;
                            int[][] visit = new int[N][M];
                            Queue<Node> Q = new LinkedList<>();
                            Q.add(new Node(i,j));
                            visit[i][j] = 1;
                            while(!Q.isEmpty()){
                                Node tmp = Q.poll();
                                for (int dir = 0; dir < 4; dir++) {
                                    int nx = tmp.x + dx[dir];
                                    int ny = tmp.y + dy[dir];
                                    if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                                        continue;
                                    if ( visit[nx][ny] == 0 && arr[nx][ny] == '0') {
                                        Q.add(new Node(nx, ny));
                                        visit[nx][ny] = 1;
                                    }else if ( visit[nx][ny] == 0 && arr[nx][ny] == '1'){
                                        cnt++;
                                        arr[nx][ny] = '0';
                                        visit[nx][ny] = 1;
                                    }
                                }
                            }
                            break OUTTER;
                        }
            }
            if(cnt== 0){
                break;
            }else{
                prev= cnt;
                time++;
            }
        }
        System.out.println(time);
        System.out.println(prev);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
