package simulation;

import java.util.*;
import java.io.*;

public class SW6485 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/SW6485.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            StringTokenizer str = null;
            for (int i = 0; i < N; i++) {
                str = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(str.nextToken());
                arr[i][1] = Integer.parseInt(str.nextToken());
                System.out.println(Arrays.toString(arr[i]));
            }
            StringBuilder build = new StringBuilder("#" + test + " ");
            int P = Integer.parseInt(br.readLine());
            System.out.println("P " + P);
            for(int dum = 0 ; dum < P ; dum++ ){
                int NUM = Integer.parseInt(br.readLine());
                System.out.println(NUM);
                ArrayList<Integer> arrL = new ArrayList<>();
                for(int i = 0 ; i < N ; i++ ){
                    if(NUM >= arr[i][0] && NUM <= arr[i][1] ){
                        arrL.add(i+1);
                    }
                }
                Collections.sort(arrL);
                    build.append( Integer.toString(arrL.size()) + " " );
            }
            System.out.println(build.toString());
        }

    }

}
