package Greedy.Sort;
import java.util.*;
import java.io.*;

public class BO1926 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Greedy/Sort/BOJ1926.txt"));
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer str = null;
        for(int i = 0 ; i < test ; i++){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num+1];
            for(int j = 0 ; j < num ; j++){
                str = new StringTokenizer(br.readLine());
                arr[ Integer.parseInt(str.nextToken()) ] = Integer.parseInt(str.nextToken());
                // 인덱스는 면접순이고, 배열에 들어가는 값은 서류점수값이다
                // 그러므로 면접의 순위는 이미 정렬이 된것이다.
            }
            int tmp = arr[1];
            int cnt = 1; // 무조건 한명은 데리고 간다
            for(int j = 2 ; j < num+1 ; j++){
                if(arr[j] < tmp ){
                    tmp =arr[j];
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        }

    }
}
