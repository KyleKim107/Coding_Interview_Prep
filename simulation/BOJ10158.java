package simulation;

import java.util.*;
import java.io.*;

public class BOJ10158 {
    public static int[] dx= {1,-1, -1, 1};
    public static int[] dy= {1,1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(str.nextToken()), y = Integer.parseInt(str.nextToken());
        int T = Integer.parseInt(br.readLine()), dir = 0;
        for (int i = 0; i < T; i++) {
            x += dx[dir];
            y += dy[dir];
            // System.out.println("dir :" + dir);
            if(x == N && y == M || x == N && y == 0 || x == 0 && y == 0 || x == 0 && y == M ){
                dir = (dir + 2) % 4;
            }else if (x == N) {
                dir = ((dir == 0) ? 1 : 2);
            } else if (y == M) {
                dir = ((dir == 1) ? 2 : 3);
            }else if(y == 0){
                dir = ((dir == 3) ? 2 : 1);
            }else if(x == 0){
                dir = ((dir == 1) ? 0 : 3);
            }
            // System.out.println(x + " " + y);
        }
        System.out.println(x + " " + y);

    }

}
