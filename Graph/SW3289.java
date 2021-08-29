package Graph;

import java.util.*;
import java.io.*;

public class SW3289 {

    public static int[] parent;

    public static int find(int x ){
        if(parent[x] != x){
            return parent[x] = find(parent[x]);
        }
        return x;
    }
    public static void union(int x , int y){
        x = find(x);
        y = find(y);
        if(x < y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/SW3289.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null; 
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            String answer = "";
            str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken());
            parent = new int[N + 1];
            for (int i = 0; i < N + 1; i++) {
                parent[i] = i;
            }
            for(int i = 0 ; i < M ; i++ ){
                str = new StringTokenizer(br.readLine());
                int first = Integer.parseInt( str.nextToken() ) , a = Integer.parseInt( str.nextToken() ), b  = Integer.parseInt( str.nextToken() );
                if(first == 0){
                    union(a, b);
                }else{
                    answer += ((find(a) == find(b))? "1" : "0");
                }
            }
            System.out.println("#" + test + " "+ answer);
        }

    }

}
