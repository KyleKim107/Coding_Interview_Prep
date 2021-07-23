package SWEA;

import java.util.*;

public class sw1983 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] score = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
        // String[] score = { "", "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
        int tc = sc.nextInt();
        for (int test = 1; test <= tc; test++) {
            int N = sc.nextInt();
            int divider = N / 10;
            int K = sc.nextInt();
            int[][] student = new int[N + 1][2];
            int[][] stStrore = new int[(N/2)][N/10];
            double cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                int mid = sc.nextInt();
                int fin = sc.nextInt();
                int assign = sc.nextInt();
                cnt = mid * (3.5 / (double) 10) + fin * (4.5 / (double) 10) + assign * (2.0 / (double) 10);
                student[i][0] = (int) cnt; // 에러 주의
                student[i][1] = i;

            }
            // System.out.println(Arrays.toString(student[1]));
            Arrays.sort(student, new Comparator<int[]>() {
                @Override
                public int compare(final int[] entry1, final int[] entry2) {

                    // To sort in descending order revert
                    // the '>' Operator
                    if (entry1[0] < entry2[0]) {
                        return 1;
                    } else {
                        return -1;
                    }
                }

            });
            for (int i = 0; i < N + 1; i++) {
                System.out.println(Arrays.toString(student[i]));
            }
            int k = 0;int result = 0;
            for (int i = 0; i < (N/2) ; i++) {
                for(int j = 0 ; j < N/10 ; j++){
                    stStrore[i][j] = student[k][1];
                    if (student[k][1] == K){
                        result = i;
                    }
                        k++;
                }
            }
            System.out.printf("#%d %s\n",test ,score[ result ] );
            
        }
    }
}
