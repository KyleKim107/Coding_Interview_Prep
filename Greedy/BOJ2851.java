package Greedy;

import java.util.*;
import java.io.*;

public class BOJ2851 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Greedy/BOJ2851.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (Math.abs(100 - cnt) >= Math.abs(100 - cnt - tmp))
            cnt += tmp;
            else
                break;
        }
        System.out.println(cnt);
    }
}
