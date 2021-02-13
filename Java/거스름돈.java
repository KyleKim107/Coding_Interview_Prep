package Java;
import java.io.*;
import java.util.*;
public class 거스름돈 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
       int x = 1260;
       int[] a  = {500,100, 50, 10};
       int cnt = 0;
       for(int i = 0 ; i < 4 ; i++){
            cnt += x / a[i];
            // System.out.println(cnt);
            x = x %a[i];
       }
       
       System.out.println(cnt);
    }
}
