package SSAFY.day1;
import java.util.*;

public class CheckPoint {
    public static void main(String[] z){
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int weight = sc.nextInt();
        int coeff = weight + 100 -height;
        System.out.printf("비만수치는 %d입니다\n", coeff);
        if (coeff > 0 ){
            System.out.print("당신은 비만이군요");
        }
    }
    
}
