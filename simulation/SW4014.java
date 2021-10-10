package simulation;

import java.util.*;
import java.io.*;

public class SW4014 {

    public static int[][] map;
    public static boolean[][] set;
    public static int N=0,X=0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/swea/4131.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T=Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int ans=0;
//            입력
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < N; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
 
            int idx=0;
            //가로
            set = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                idx=0;
                top:
                while(true) {
                    if(idx==N-1) {    //끝까지 이상없이 왔음.
                        ans++;
                        break;
                    }
                    if(map[i][idx]==map[i][idx+1]) {    //높이가 같으면 다음칸 감
                        idx++;
                    }
                    else if(map[i][idx]-1==map[i][idx+1]) {    //1칸 내려감
                        for (int s = 1; s <= X; s++) {
                            //경계안이고, 높이1칸차이 유지하면서, 설치안되었으면
                            if((idx+s)<N && map[i][idx]-1 == map[i][idx+s] && set[i][idx+s]==false) {
                                set[i][idx+s]=true;
                            }
                            else {    //설치 못함
                                break top;
                            }
                        }
                        //X칸 설치 다끝남
                        idx = idx+X;
                    }
                    else if(map[i][idx]+1==map[i][idx+1]) {
                        for (int s = 0; s < X; s++) {
                            //경계안이고, 높이1칸차이 유지하면서, 설치안되었으면
                            if((idx-s)>=0 && map[i][idx+1]-1 == map[i][idx-s] && set[i][idx-s]==false) {
                                set[i][idx-s]=true;
                            }
                            else {    //설치 못함
                                break top;
                            }
                        }
                        //X칸 설치 다끝남
                        idx++;
                    }
                    else {    //높이차이 2칸이상
                        break;
                    }
                }
            }
        }
    }
    
}
