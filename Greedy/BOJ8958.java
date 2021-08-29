package Greedy;

import java.util.*;
import java.io.*;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int test = 0 ; test < N ; test++ ){
            String str = br.readLine(); int counter = 1, answer = 0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'O'){
                    answer +=  counter;
                    counter++;
                }else{
                    counter = 1;
                }
            }
            System.out.println(answer);
        }
    }

}
