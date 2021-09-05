package simulation;

import java.util.*;
import java.io.*;

public class SW7964 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/SW7964.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken());
            int cnt = 0, tick = 0;
            char[] arr = new char[N];
            arr = br.readLine().replace(" ", "").toCharArray();
                for (int i = 0; i < N; i++) {
                    if (arr[i] == '1') {
                        tick = 0;
                    } else if (arr[i] == '0') {
                        tick++;
                        if (tick == M) {
                            cnt++;
                            arr[i] = '1';
                            tick = 0;
                        }
                    }
                }
                System.out.println(Arrays.toString(arr));
        
            System.out.println(cnt);
        }
    }

}
