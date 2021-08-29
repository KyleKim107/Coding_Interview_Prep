package simulation;

import java.util.*;
import java.io.*;

public class BOJ2527 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ2527.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test = 0; test < 4; test++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int[] arr = new int[8];
            for (int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(str.nextToken());
            }
            
            outter: for (int i = 0; i < 4; i++) {
                int tmp = arr[i];
                for (int j = 4; j < 8; j++) {
                    if (tmp == arr[j]) {
                        System.out.println("b");
                        break outter;
                    }
                }
            }
        }
    }

}
