package Graph.Dijkstra;
import java.util.*;
import java.io.*;
public class SW1249 {
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Graph/Dijkstra/SW1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= TC ; test++ ){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N], dist = new int[N][N];
            for(int i = 0 ; i < N ; i++ ){
                String tmp = br.readLine();
                for(int j = 0 ; j < N ; j++ ){
                    arr[i][j] = tmp.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            PriorityQueue<Node> Q = new PriorityQueue<>();
            Q.offer(new Node(0,0,arr[0][0]));
            dist[0][0] = arr[0][0];
            while(!Q.isEmpty()){
                Node tmp = Q.poll();
                for(int dir = 0 ; dir < 4 ; dir++ ){
                    int nx = tmp.x + dx[dir];
                    int ny = tmp.y + dy[dir];
                    if(nx < 0 ||  nx >= N || ny < 0 ||  ny >= N) continue;
                    if(dist[nx][ny] > dist[tmp.x][tmp.y] + arr[nx][ny]){
                        dist[nx][ny] = dist[tmp.x][tmp.y] + arr[nx][ny];
                        Q.offer( new Node(nx, ny, dist[nx][ny] )) ;
                    }
                }
            }
            System.out.println("#"+ test + " " + dist[N-1][N-1]);
        }
    }


    static class Node implements Comparable<Node>{
        int x,y,v;
        public Node(int x, int y, int v){
            this.x=x;
            this.y=y;
            this.v=v;
        }
        @Override
        public int compareTo(Node o){
            return this.v - o.v;
        }
    }
}
