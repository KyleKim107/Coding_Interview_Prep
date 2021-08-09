package Data_Structure.Stack;

import java.util.*;
import java.io.*;
public class SW1861{
    static int[] dx = { -1,  1, 0, 0,};
    static int[] dy = {0, 0, -1, 1};
    static int roomNum = Integer.MAX_VALUE;
    static int MaxNum = -1;
    static int[][] map = null;

    public static void dfs(int currX , int currY , int start , int turn ){
        int cnt = 0;
        for(int dir = 0  ; dir < 4 ; dir++){
            int nx = currX + dx[dir];
            int ny = currY + dy[dir];
            if (0<= nx && nx <  map.length && 0<= ny && ny < map.length
            && map[currX][currY] +1  == map[nx][ny] ){
                dfs(nx , ny , start , turn + 1);
                cnt += 1;
            }
        }
        if (cnt == 0){
            if (MaxNum <= turn ){
                roomNum =  ((roomNum >= start)? start:roomNum);
                MaxNum = turn;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tmp = null;
        int TC = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= TC ; test++ ){
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            roomNum = Integer.MAX_VALUE;MaxNum = -1;
            for(int i = 0 ; i < N ; i++){
                tmp = new StringTokenizer( br.readLine() )  ;
                for(int j = 0 ; j < N ; j++){
                    map[i][j] = Integer.parseInt(tmp.nextToken());
                }
            }
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    dfs(i , j , map[i][j] ,  1);
                }
            }
            System.out.printf("#%d %d %d\n" , test, roomNum , MaxNum);
        }
    }
}