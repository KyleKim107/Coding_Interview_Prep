package Greedy.Sort;
import java.util.*;
import java.io.*;

public class JO1828 {
    public static int maxV ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str= null;
        int[][] arr = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            str = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(str.nextToken());
            arr[i][1] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr , new Comparator<int[]>(){
            @Override
            public int compare(int[] o1 , int[] o2){
                return Integer.compare(o1[1], o2[1]);
            }
            
        });

        maxV = arr[0][1];
        int cnt = 1;
        for(int i = 1 ; i < N ; i++){
            if( maxV < arr[i][0]){
                maxV = arr[i][1];
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}

// 4
// -8 5
// -10 36
// 10 73
// 27 44