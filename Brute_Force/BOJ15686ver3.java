package Brute_Force;

import java.util.*;
import java.io.*;

public class BOJ15686ver3 {
    public static class Pair{
        int x,y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static List<Pair> ChArr , HomeArr;
    public static int N, M, minV = Integer.MAX_VALUE;
    public static int len ;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Brute_Force/BOJ15686.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        ChArr = new ArrayList<>();
        HomeArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(str.nextToken());
                if (tmp == 2) {
                    ChArr.add(new Pair(i,j));
                } else if (tmp == 1) {
                    HomeArr.add(new Pair(i,j));
                }
            }
        }
        List<Pair> tmp = new ArrayList<>();
        len = ChArr.size();
        func(0, 0 ,tmp);
        System.out.println(minV);
    }// end of main

    public static void func(int depth, int ChiNum, List<Pair> visit ) {
        if ( ChiNum == M) {
            dist(visit);
            return;
        }
        if (depth == len ) {
            return;
        }
        visit.add(ChArr.get(depth));
        func(depth + 1, ChiNum + 1, visit);
        visit.remove(visit.size()-1);
        func(depth + 1, ChiNum, visit);

    }

    public static void dist(List<Pair> visit) {
        int totalCnt = 0 ,CHlength = visit.size(),HOMElen = HomeArr.size();
        for (int i = 0; i < HOMElen; i++) {
            Pair tmpHouse = HomeArr.get(i);
            int cnt = Integer.MAX_VALUE;

            for (int j = 0; j < CHlength; j++) {
                Pair tmpChiken = visit.get(j);
                cnt = Math.min( cnt, Math.abs(tmpHouse.x - tmpChiken.x) + Math.abs(tmpHouse.y - tmpChiken.y));
            }
            totalCnt += cnt;
        }
        minV = Math.min(minV, totalCnt);
    }
}
