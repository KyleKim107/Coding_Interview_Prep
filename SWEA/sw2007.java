package SWEA;
import java.util.*;

public class sw2007 {
    public static void main(String[] z){
    Scanner sc = new Scanner(System.in);
    

    String a = sc.next();
    int len = a.length();
    for(int i = 0 ; i < 11 ; i++){
        System.out.println(i);
        if ( len% ( i+ 1) == 0){
       String curr =  a.substring(0,i);
        int start = i; int total = len /(i+1);
        System.out.println(curr);
        int cnt = 1;
        while(!(start >= len) && start< len+ 1){
            if(curr == a.substring(start+1, start)){
                System.out.println(a.substring(start+1, start));
                cnt += 1;
            }
            start += start;
        System.out.println(cnt);
       
       }
        }
    }

}
}