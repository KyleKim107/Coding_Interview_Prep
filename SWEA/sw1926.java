package SWEA;
import java.util.*;
public class sw1926 {
    public static void main(String[] z){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
            for( int i = 1; i < num + 1; i++ ){
                String tmp = ""+ i;
                int cnt = 0;
            for( int j = 0 ; j < tmp.length() ; j++){
                	if (tmp.charAt(j) == '3' || tmp.charAt(j) == '6' || tmp.charAt(j) == '9'   ){
                        cnt += 1;
                    }
                }
               if(cnt > 0){
                   for(int k = 0 ; k < cnt ; k++){
                   System.out.print("-" );
                   }
                  System.out.print(" " );
               }else{
                  System.out.printf("%d ", i  );
               }
            }

    }
}
