package SWEA;
import java.util.*;

public class sw1970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] money = { 50000,10000,
                            5000,
                            1000,
                            500,
                            100,
                            50,
                            10};
        int[] num = new int[8];

        int m = sc.nextInt(); int result = 0 ;

        for(int i = 0 ; i < 8 ; i++ ){
            num[i] = m / money[i];
            m = m % money[i];
        }
        System.out.println(Arrays.toString( num ));

        
    }
    
}
