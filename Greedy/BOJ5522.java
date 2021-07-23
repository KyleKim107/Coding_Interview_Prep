package Greedy;
import java.util.Scanner;

public class BOJ5522 {
    public static void main(String[] Args){
    Scanner sc = new Scanner(System.in);
    int result = 0;
    for( int i = 0 ; i < 5 ; i++){
        result += sc.nextInt();
    }

    System.out.println(result);
    sc.close();
    }

}
