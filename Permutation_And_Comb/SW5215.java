package Permutation_And_Comb;
import java.util.*;
import java.io.*;

public class SW5215 {
    public static int satisfy = -1;
    public static int total, hamNum;
    public static int[][] arr;

    public static void func(int numEle , int totalSatisfaction , int totalCal ){
        if(totalCal > total){
            return;
        }
        if(numEle == hamNum){ // 끝까지 가면 종료
            satisfy = Math.max(totalSatisfaction ,satisfy );
            return;
        }
        func(numEle +1 , totalSatisfaction + arr[numEle][0] , totalCal + arr[numEle][1] ); // 고르고
        func(numEle +1 , totalSatisfaction  , totalCal ); // 안고르고
    }
    public static void main(String[] args) throws IOException{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt( br.readLine());
                StringTokenizer str = null;

		for(int test_case = 1; test_case <= TC; test_case++)
		{
            satisfy = -1;
		     str = new StringTokenizer(br.readLine()) ;
            hamNum = Integer.parseInt(str.nextToken());
            total = Integer.parseInt(str.nextToken());
            arr = new int[hamNum][2];
            for(int i = 0 ; i < hamNum ; i++){
                str = new StringTokenizer(br.readLine()) ;
                    arr[i][0]=  Integer.parseInt(str.nextToken());
                    arr[i][1]= Integer.parseInt(str.nextToken());
            }
            func( 0,0,0);
            System.out.printf("#%d %d\n" ,test_case, satisfy);

		}
    }
}
