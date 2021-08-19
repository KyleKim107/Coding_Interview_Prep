package Div_and_Conquer;

import java.util.*;

import java.io.*;

public class BOJ1992 {
    public static StringBuilder result = new StringBuilder();
    public static int[][] arr;

    public static void func(int size ,int x, int y) {

		if(isPossible(x, y, size)) {
			result.append(arr[x][y]);
			return;
		}

		int newLen = size / 2;

		result.append('(');

		func(newLen, x, y);						// 1
		func(newLen,x, y + newLen);				// 2
		func(newLen, x + newLen, y);				// 3
		func( newLen, x + newLen, y + newLen);	// 4

		result.append(')');
	}

	public static boolean isPossible(int x, int y, int size) {
		int value = arr[x][y];
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(value != arr[i][j]) {
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
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
        func( n,0, 0);
        System.out.println(result);
    }

}
