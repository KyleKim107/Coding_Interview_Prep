package simulation;

import java.util.*;

import javax.lang.model.util.ElementScanner6;

import java.io.*;

public class BOJ10163 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ10163.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int S = 1001;
        int[][] arr = new int[S][S];
        int[][] papers = new int[num][4];
        for (int dummy = 0; dummy < num; dummy++) {
            // 가장 왼쪽 아래 칸의 번호와 너비, 높이를 나타내는 네 정수로 표현한다.
            StringTokenizer str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken()), y = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken()), N = Integer.parseInt(str.nextToken());
            papers[dummy][0] = x;
            papers[dummy][1] = y;
            papers[dummy][2] = M;
            papers[dummy][3] = N;
            for (int j = S - 1 - y; j > S - 1 - y - N; j--) {
                for (int i = x; i < x + M; i++) {
                    // System.out.print(" j " + j + " i " + i );
                    arr[j][i] = dummy + 1;
                }
            }
            // System.out.println();
        }
        // for(int i = 0 ; i < arr.length ; i++ ){
        // System.out.println(Arrays.toString(arr[i]));
        // }
        for (int dummy = 0; dummy < num; dummy++) {
            int x = papers[dummy][0], y = papers[dummy][1], M = papers[dummy][2], N = papers[dummy][3];
            int cnt = 0;
            for (int j = S - 1 - y; j > S - 1 - y - N; j--) {
                for (int i = x; i < x + M; i++) {
                    if (arr[j][i] == (dummy + 1)) {
                        cnt += 1;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

}
