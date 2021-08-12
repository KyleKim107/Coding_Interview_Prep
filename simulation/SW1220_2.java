package simulation;

import java.util.*;
import java.io.*;

public class SW1220_2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/SW1220.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                str = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = false;
                for (int j = 0; j < N; j++) {
                    int curr = arr[j][i];
                    if (curr == 0) continue;

                    if(curr == 1){
                        flag = true;
                    }else if(flag && curr == 2){
                        cnt += 1;
                        flag = false;
                    }
                }
            }
        System.out.println("#" + test_case + " "+ cnt);
        } // end of testcases
        br.close();
    }
}
