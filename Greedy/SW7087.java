package Greedy;

import java.util.*;
import java.io.*;

public class SW7087 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Greedy/SW7087.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                arr[i] = str;
            }
            Arrays.sort(arr);
            int cnt = 0,index = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i].charAt(0) == 'A' + index){
                    index++;
                    cnt++;
                }
            }

            System.out.println("#" + test + " " + cnt);
        }
    }

}
