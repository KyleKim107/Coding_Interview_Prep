package Div_and_Conquer;
import java.util.*;
import java.io.*;

public class BOJ1074ver2 {
    public static int cnt = 0;
    public static void func(int x, int y, int n){
        if(n == 2){
            if(x % n == 0 && y %  n == 1) cnt += 1; // 2
            else if(x % n == 1 && y %  n == 0) cnt += 2; // 3
            else if(x % n == 1 && y %  n == 1) cnt += 3; //4
            return;
        }
        int loc =0;
        int newLen = n /2 ;
        if( x % n < newLen  && y % n < newLen  ) loc = 0;  // 1사분면  row와 col를 n으로 나눠서 나머지가 절반보다 낮다면
        else if( x % n < newLen  && y % n >= newLen  ) loc = 1;  // 2사분면 row와 col를 n으로 나눠서 col의나머지가 절반보다 낮다면
        else if( x % n >= newLen  && y % n < newLen  ) loc = 2;  // 3사분면
        else loc =3;
        int mulLen = newLen * newLen;
        cnt += (mulLen * loc);
        func( x , y , newLen );
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int r = Integer.parseInt(str.nextToken());
        int c = Integer.parseInt(str.nextToken());
        func(r,c, 1 << N);
        System.out.println(cnt);
    }
    
}
