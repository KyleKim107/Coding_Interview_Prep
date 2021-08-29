package simulation;

import java.util.*;
import java.io.*;

public class BOJ2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        int N = Integer.parseInt(br.readLine());
        int verMax = Integer.MIN_VALUE;
        int horMax = Integer.MIN_VALUE;
        int[][] arr = new int[6][2];
        for (int i = 0; i < 6; i++) {
            str = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(str.nextToken()), dist = Integer.parseInt(str.nextToken());
            arr[i][0] = dir;
            arr[i][1] = dist;
            if (dir == 3 || dir == 4) {
                verMax = Math.max(verMax, dist);
            } else if (dir == 1 || dir == 2) {
                horMax = Math.max(horMax, dist);
            }
        }
        int inner = horMax * verMax;
        for (int i = 0; i < 5; i++) { // 네가지 반시계방향 ㄱ자의 패턴을 분석한다
            if ((arr[i][0] == 1 && arr[i + 1][0] == 3) || (arr[i][0] == 4 && arr[i + 1][0] == 1)
                    || (arr[i][0] == 2 && arr[i + 1][0] == 4) || (arr[i][0] == 3 && arr[i + 1][0] == 2)) {
                inner -= (arr[i][1] * arr[i + 1][1]);
            }
        }
        if (inner == horMax * verMax) { // 끝나는점과 시작하는 점까지 커버해서 (이거 없으면 틀려)
            if ((arr[5][0] == 1 && arr[0][0] == 3) || (arr[5][0] == 4 && arr[0][0] == 1)
                    || (arr[5][0] == 2 && arr[0][0] == 4) || (arr[5][0] == 3 && arr[0][0] == 2)) {
                inner -= (arr[5][1] * arr[0][1]);
            }
        }
        System.out.println(((inner) * N));
    }
}
