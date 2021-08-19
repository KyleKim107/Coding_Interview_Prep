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
                if(arr[i][j] != 'X'){ // x and y 둘다 체크하는데 왜? 백조까지 포함해야지 
                    waterQ.offer(new Node(i,j));
                }
            }
        }
        visit[swan[0].x][swan[0].y] = 1;
        Q.offer(swan[0]); int day = 0; boolean flag = false;
        while(true){
            Queue<Node> nextQ = new LinkedList<Node>();
            while(!Q.isEmpty()){ // 첫번째 백조에서 시작한다
                Node node = Q.poll();
                if(swan[1].x == node.x && swan[1].y == node.y ){
                    flag = true;
                    break;
                }
                for(int dir = 0 ; dir < 4 ; dir++){
                    int nx = node.x + dx[dir];
                    int ny = node.y + dy[dir];
                    if( 0 >nx || nx>= R || 0 > ny || ny >= C || visit[nx][ny] == 1){continue;}

                    visit[nx][ny] = 1; // 실질적 체크는 여기서 해준다.
                    if(arr[nx][ny] == 'X'){
                        nextQ.offer(new Node(nx,ny)); //X는 녹인다음 다움 이터레이션에서 탐색해준다
                        continue;
                    }
                    Q.offer(new Node(nx,ny)); // 물이면 탐색해준다.
                }
            }
            if(flag){break;}
            Q = nextQ;
            int len = waterQ.size();
            for(int i = 0 ; i < len ; i++){
                Node node = waterQ.poll();
                // visit에 체크해줄 필요없다, 다음 이터레이션에서 Q로 체크해준다.
                for(int dir = 0 ; dir < 4 ; dir++){
                    int nx = node.x + dx[dir];
                    int ny = node.y + dy[dir];
                    if(0 > nx || nx >= R || 0 > ny || ny >= C){ continue; }
                    if(arr[nx][ny] == 'X'){
                        arr[nx][ny] = '.';
                        waterQ.offer(new Node(nx , ny));
                    }
                }
            }
            for(int i = 0 ; i < R ; i++){
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println();
            day += 1;
        }
        System.out.println(day);
    } // end of Main
}