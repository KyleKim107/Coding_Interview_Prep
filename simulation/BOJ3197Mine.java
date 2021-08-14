package simulation;

import java.util.*;
import java.io.*;

public class BOJ3197Mine {
    public static class Node{
        int x,y;
        public Node(int x, int y ){
            this.x= x;
            this.y = y;
        }
    }
    public static int R, C;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ3197.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        Queue<Node> Q = new LinkedList<Node>();
        Queue<Node> waterQ = new LinkedList<Node>();
        int[][] visit = new int[R][C];
        Node[] swan = new Node[2]; int index = 0;
        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = tmp[j];
                if(arr[i][j] == 'L'){
                    swan[index++] = new Node(i,j);
                }
                if(arr[i][j] == '.'){
                    waterQ.offer(new Node(i,j));
                }
            }
        }
        visit[swan[0].x][swan[0].y] = 1;
        Q.offer(swan[0]); int day = 0; boolean flag = false;
        while(true){
            Queue<Node> nextQ = new LinkedList<Node>();
            while(!Q.isEmpty()){
                Node node = Q.poll();
                if(swan[1].x == node.x && swan[1].y == node.y ){
                    flag = true;
                    break;
                }
                for(int dir = 0 ; dir < 4 ; dir++){
                    int nx = node.x + dx[dir];
                    int ny = node.y + dy[dir];
                    if( 0 >nx || nx>= R || 0 > ny || ny >= C || visit[nx][ny] == 1){continue;}

                    visit[nx][ny] = 1;
                    if(arr[nx][ny] == 'X'){
                        
                    }
                    
                }



            }

        }





    }
}