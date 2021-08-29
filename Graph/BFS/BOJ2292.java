package Graph.BFS;

import java.util.*;
import java.io.*;

public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int cnt = 1, curr = 1, turn = 0;
        while (true) {
            turn++;
            if (N <= curr) {
                break;
            }
            curr += (6 * cnt);
            cnt++;
        }
        System.out.println(turn);
    }
}
