package simulation;

import java.util.*;
import java.io.*;

public class JO1037 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/JO1037.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        ArrayList<Integer> rowArr = new ArrayList<>(); 
        ArrayList<Integer> colArr = new ArrayList<>(); 
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int row = -1, col = -1;
        for (int i = 0; i < N; i++) {
            int cntRow = 0, cntCol = 0;

            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    cntRow += 1;
                }
                if (arr[j][i] == 1) {
                    cntCol += 1;
                }
            }
            if (cntRow % 2 != 0) {
                rowArr.add(i);
            }
            if (cntCol % 2 != 0) {
                colArr.add(i);
            }
        }
        if ( colArr.size() == 0 && rowArr.size() == 0 ) {
            System.out.println("OK");
        }else if (colArr.size() == 1 && rowArr.size() == 1 ) {
            System.out.println("Change bit (" + (rowArr.get(0)+1)+"," +(colArr.get(0)+1)+ ")");
        } 
        else {
            System.out.println("Corrupt");
        } 

    }
}

// System.out.println("cntRow " + cntRow+ " cntCol :" + cntCol);