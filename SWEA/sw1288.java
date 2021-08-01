package SWEA;
import java.util.*;

public class sw1288 {
    public static int[] calc(int num , int[] arr){
        while (num > 0){
            arr[num % 10] ++;
            num /= 10;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int n  = sc.nextInt();
        int i = 0;
        int result = 0;
        for(i = 1; i < 100000 ; i++){
            arr = calc(n *i , arr);
            result = n *i;
            boolean flag = true;
            for(int j = 0 ; j < 10 ; j++){
                if(arr[j] == 0){
                    flag = false;
                    break;
                }
            }
            System.out.println(Arrays.toString(arr));
            if(flag){
                break;
            }
        }
        System.out.println(result);
    }
}
