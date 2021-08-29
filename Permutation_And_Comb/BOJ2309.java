package Permutation_And_Comb;

import java.util.*;
import java.io.*;

public class BOJ2309 {
    public static int[] arr;
    public static void func(int depth, int[] visit,  int total , int r ) {
        if (r == 2 && total == 100) {
                for (int i = 0; i < 9; i++) {
                    if (visit[i] == 0) {
                        System.out.println(arr[i]);
                    }
                }
                System.exit(0);;
        }
        if(depth == 9){return;}

        visit[depth] = 1;
        func(depth + 1, visit,  total - arr[depth], r + 1);
        visit[depth] = 0;
        func(depth + 1, visit, total, r );
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Permutation_And_Comb/BOJ2309.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9]; int cnt = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            cnt += arr[i];
        }
        Arrays.sort(arr);
        func(0, new int[9] , cnt , 0);
    }

}
