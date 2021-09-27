package Dynamic_Programming.KMP;

import java.util.*;
import java.io.*;

public class BOJ1786 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Dynamic_Programming/KMP/BOJ1786.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();

        int[] pi = new int[P.length];
        for (int  i = 1, j = 0; i < P.length; i++) {
            while (j > 0 && P[i] != P[j]) {
                j = pi[j - 1];
            }
            if (P[i] == P[j]) {
                pi[i] = ++j;
            }
        }
        System.out.println(Arrays.toString(pi));
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0, j = 0 ; i < T.length ; i++ ){
            while(j > 0 && T[i] != P[j]){
                j = pi[j-1];
            }
            if(T[i] == P[j]){
                if(j == P.length -1){
                    cnt++;
                    list.add(i - P.length+2);
                    j = pi[j];
                }else{
                    j++;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(list);
        for(Integer tmp : list){
            System.out.print(tmp +" ");
        }

    }

}
