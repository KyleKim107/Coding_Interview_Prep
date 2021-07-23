package SWEA;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1;t<=tc;t++) {
            int N=sc.nextInt(); // n
            int len=sc.nextInt(); // k
			
            int puzzle[][] = new int [N][N];
            int Size[] = new int[N+1];
			
            for(int y=0;y<N;y++)
                for(int x=0;x<N;x++)
                    puzzle[y][x] = sc.nextInt();

            for(int y=0 ;y<N ;y++) { //가로
                int cnt=0;
                for(int x=0;x<N;x++) { 
                    if (puzzle[y][x] == 0) { // 0은 못넣는 칸임
                        Size[cnt]++;
                        cnt=0;
                    }
                    else{ // 1일때는 cnt++ 
                        cnt++;
                    }
                }
                Size[cnt]++;
            }
            System.out.println(Arrays.toString(Size));
            for(int x=0;x<N;x++) {
                int cnt=0;
                for(int y=0;y<N;y++) {
                    if (puzzle[y][x] == 0) {
                        Size[cnt]++;
                        cnt=0;
                    }
                    else
                        cnt++;
                }
                Size[cnt]++;
            }
            System.out.println(Arrays.toString(Size));

            System.out.println("#"+t+" "+Size[len]);
        }
        sc.close();
    }
}
