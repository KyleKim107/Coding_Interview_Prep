package Graph.Dijkstra;
import java.util.*;
import java.io.*;
public class BOJ4485ver2 {
    public static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    public static int[][] arr, dist;
    public static PriorityQueue<Node> Q;
    public static int INFINITY = Integer.MAX_VALUE, test = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/BOJ1194.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true){
        int N = Integer.parseInt(br.readLine());
        if(N == 0) return;
        arr = new int[N][N];
        dist = new int[N][N];
        for(int i = 0 ; i < N ; i++ ){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++ ){
                arr[i][j] = Integer.parseInt(str.nextToken());
                dist[i][j] = INFINITY;
            }
        }
        Q = new PriorityQueue<>();
        Q.offer(new Node(0,0, arr[0][0]));
        dist[0][0] = arr[0][0];
        while(!Q.isEmpty()){
            Node tmp = Q.poll();
            for(int dir = 0 ; dir < 4 ; dir++ ){
                int nx = tmp.x + dx[dir];
                int ny = tmp.y + dy[dir];
                if( nx <0 || nx>= N || ny < 0 || ny >= N) continue;
                if(dist[nx][ny] > dist[tmp.x][tmp.y] + arr[nx][ny] ){
                    dist[nx][ny] = dist[tmp.x][tmp.y] + arr[nx][ny];
                    Q.offer(new Node(nx, ny,dist[tmp.x][tmp.y] + arr[nx][ny] ));
                }
            }
        }
        System.out.println("Problem " + (++test) + ": " +dist[N-1][N-1]);

    }
        
    }
    static class Node implements Comparable<Node>{
        int x,y,v;
        public Node(int x, int y , int v){
            this.x =x;
            this.y = y;
            this.v =v;
        }
        @Override
        public int compareTo(Node o){
            return this.v - o.v;
        }
    }
    
}
