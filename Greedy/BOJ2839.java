package Greedy;
import java.util.*;
import java.io.*;
public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n > 0){
            if (n % 5 == 0){
                n -= 5;
                cnt += 1;
            }else{
                n -= 3;
                cnt += 1;
            }
        }
        System.out.println(n < 0 ? -1 : cnt);
    }

}
