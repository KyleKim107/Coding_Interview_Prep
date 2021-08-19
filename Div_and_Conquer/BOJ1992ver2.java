package Div_and_Conquer;

import java.util.*;
import java.io.*;

public class BOJ1992ver2 {
    public static int[][] arr;
    public static StringBuilder str = new StringBuilder();

    public static void func(int x, int y, int n) {
        if(ok(x,y,n)){
            str.append(arr[x][y]);
            return;
        }
        str.append("(");
        int newLen = n / 2;
        func( x , y , newLen); // 1
        func( x , y + newLen , newLen); // 2
        func( x + newLen , y , newLen); // 3
        func( x + newLen, y + newLen , newLen); //4
        str.append(")");
    }

    public static boolean ok(int x, int y, int end) {
        int tmp = arr[x][y];
        for (int i = x; i < x + end; i++) {
            for (int j = y; j < y + end; j++) {
                if(arr[i][j] != tmp){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Div_and_Conquer/BOJ1992.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        func(0, 0, n);
        System.out.println(str);
    }

}
