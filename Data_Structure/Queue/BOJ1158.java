package Data_Structure.Queue;

import java.util.*;
import java.io.*;
public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), K = Integer.parseInt(str.nextToken());
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++ ){
            q.add(i);
        }
        int tic = 1;
        while(! q.isEmpty() ){

            if (tic % (K) == 0){
                result.add(q.remove());
            }else{
                q.add(q.remove());
            }
            tic += 1;
        }
            System.out.print("<");
        for(int i = 0 ; i < N -1 ; i++){
            System.out.print(result.remove() + ", ");
        }
        System.out.print(result.remove() + ">");

    }
}
