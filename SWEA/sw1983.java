package SWEA;

import java.util.*;

public class sw1983 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] score = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
        int tc = sc.nextInt();
        for (int test = 1; test <= tc; test++) {
            int N = sc.nextInt();
            int divider = N / 10;
            int K = sc.nextInt();
            Double[] student = new Double[N]; // 사이즈가 안맞으면 에러가 발생한다
            // int[][] stStrore = new int[(N/2)][N/10];
            double cnt = 0;
            double goal = 0.0;
            for (int i = 0; i < N ; i++) {
                int mid = sc.nextInt();
                int fin = sc.nextInt();
                int assign = sc.nextInt();
                student[i] = mid * 0.35 + fin * 0.45 + assign * 0.2;
                if(K == i+1 ){
                    goal = student[i];
                }
            }

            Arrays.sort(  student, Collections.reverseOrder() );
            // for(int i = 0 ; i < N ; i++){
                System.out.println(Arrays.toString(student));

            // }
            int index = 0;
            for (int i = 0; i < N ; i++) {
                if(goal == student[i]){
                    index = i;
                    break;
                }
            }
            index = index/(N/10);

            // System.out.println(index );
            System.out.printf("#%d %s\n", test  ,score[index]  );

            // System.out.printf("#%d %s\n",test ,score[ result ] );
            
        }
    }
}
