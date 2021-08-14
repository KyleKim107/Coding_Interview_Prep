package Brute_Force;

import java.util.*;
import java.io.*;

public class BOJ15686 {
    public static int[][] ChikenArr, HouseArr, HArr, CArr;
    public static int N, M, minV = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Brute_Force/BOJ15686.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        int[][] arr = new int[N][N];
        int chicken = 0, house = 0;
        ChikenArr = new int[N * N][2];
        HouseArr = new int[N * N][2];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(str.nextToken());
                arr[i][j] = tmp;
                if (tmp == 2) {
                    ChikenArr[chicken][0] = i;
                    ChikenArr[chicken][1] = j;
                    chicken++;
                } else if (tmp == 1) {
                    HouseArr[house][0] = i;
                    HouseArr[house][1] = j;
                    house++;
                }
            }
        }

        HArr = new int[house][2];
        CArr = new int[chicken][2];
        for (int i = 0; i < house; i++) {
            HArr[i] = HouseArr[i];
        }
        for (int i = 0; i < chicken; i++) {
            CArr[i] = ChikenArr[i];
        }
        func(0, 0, new int[chicken]);
        System.out.println(minV);
    }// end of main

    public static void func(int depth, int ChiNum, int[] visit) {
        if ( ChiNum == M) {
            dist(visit);
            return;
        }
        if (depth == visit.length ) {
            return;
        }

        visit[depth] = 1;
        func(depth + 1, ChiNum + 1, visit);
        visit[depth] = 0;
        func(depth + 1, ChiNum, visit);

    }

    public static void dist(int[] visit) {
        int totalCnt = 0;
        for (int i = 0; i < HArr.length; i++) {
            int houseX = HArr[i][0];
            int houseY = HArr[i][1];
            int cnt = Integer.MAX_VALUE;
            for (int j = 0; j < CArr.length; j++) {
                if (visit[j] == 1){
                    int chikenX = CArr[j][0];
                    int chikenY = CArr[j][1];
                    cnt = Math.min( cnt, Math.abs(houseX - chikenX) + Math.abs(houseY - chikenY));
                }
            }
            totalCnt += cnt;
        }
        minV = Math.min(minV, totalCnt);
    }

}
