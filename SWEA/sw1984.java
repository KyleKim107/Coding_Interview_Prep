package SWEA;
import java.util.*;

public class sw1984 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] month = {0,31,28,31, 30,31,30,31,31,30,31,30,31};
        int firstM = sc.nextInt();int firstD = sc.nextInt();
        int secondtM = sc.nextInt();int secondD = sc.nextInt();
        int cnt = 0;
        if( secondtM == firstM){
            cnt = month[firstM] - firstD +1;
        }else{
            cnt = month[firstM] - firstD +1;
            for(int i = firstM + 1 ; i < secondtM ;i++){
                cnt += month[i] ;
            }
            cnt += secondD;
        }
       
        System.out.println(cnt);
    }
}
