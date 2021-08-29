package Data_Structure.Deque;

import java.util.*;
import java.io.*;

public class BOJ1592 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Data_Structure/Deque/BOJ1592.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken()),
        L = Integer.parseInt(str.nextToken());
        int[] arr = new int[N];
        // Deque<Integer> deque = new LinkedList<>();
        // for (int i = 0; i < N; i++) {
        //     deque.add(0);
        // }
        int curr = 0 , turn = 0;
        while(true){
            arr[curr] += 1;
            if(arr[curr] == M) break;
            if( (arr[curr] % 2 ) != 0){
                curr = (curr +L) % N;
            }else{
                curr = (curr -L);
                if(curr < 0){
                    curr = N + curr;
                }
            }
            turn += 1;
            // System.out.println(Arrays.toString(arr));
        }
        System.out.println(turn);

    }

}
