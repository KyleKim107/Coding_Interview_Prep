package Greedy.Sort;
import java.util.*;
import java.io.*;

public class BOJ1931 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Greedy/Sort/BOJ1931.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2]; StringTokenizer str = null;
        int[] store = new int[  1<< 28];
        for(int i = 0 ; i < n ; i++ ){
            str = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(str.nextToken());
            arr[i][1] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr , (a,b) ->{
            return Integer.compare(a[1], b[1]);
        });
        for(int i = 0 ; i < n ; i++ ){
            System.out.println(Arrays.toString(arr[i]));
            if(arr[i][0] == 0){
                store[arr[i][1]]++;
            }else{
                store[arr[i][1]] = store[arr[i][0] -1] += 1 ;
            }
        }
        System.out.println(store[ arr[n-1][1]]);
    }
    
}
