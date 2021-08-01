package SWEA;
import java.util.*;

public class sw1945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 2, 3, 5 ,7 ,11};
        int[] result = new int[5];
           int n = sc.nextInt();
            for(int i = 0 ; i < 5 ; i++){
                int cnt = 0;
            	while(true){
                	if ( n % arr[i] == 0 ){
                        n = (n / arr[i]);
                        cnt += 1;
                    }else{
                        break;
                    }
                    result[i] = cnt;
                }
            }
            System.out.println(Arrays.toString(result));
    }
    
}
