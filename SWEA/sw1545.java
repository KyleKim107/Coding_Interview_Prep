package SWEA;

import java.util.*;

public class sw1545 {
    public static void main(String[] z){
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int num = sc.nextInt();
            while(num> -1) {
                System.out.printf( "%d ", num);
            	num -= 1;
            }
        }
    }
}
