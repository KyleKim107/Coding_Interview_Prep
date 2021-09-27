package Greedy.TwoPointer;
import java.util.*;
import java.io.*;
public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Greedy/TwoPointer/BOJ2003.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken());
        int[] arr= new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++ ){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        int lo = 0, hi = 0, total = 0 , answer = 0;
        while (true){
            // lo 올리는 조건: total이 M보다 같거나 클떄
            if(total >= M ) total -= arr[lo++];
            else if(hi == N) break;
            // hi 올리는 조건: hi가 N에 도달 하지 못했거나 M이 토탈보다 작을떄.
            else  total += arr[hi++];
            if(total == M ) answer++;
        }
        System.out.println(answer);

    }
    
}
