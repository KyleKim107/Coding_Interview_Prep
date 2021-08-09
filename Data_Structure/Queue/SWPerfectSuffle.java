package Data_Structure.Queue;
import java.util.*;
import java.io.*;


import java.io.*;
public class SWPerfectSuffle {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Queue<String> result = new LinkedList<>();
        for(int test = 1 ; test <=  TC ; test++){
            int len = Integer.parseInt(br.readLine());
            String[] arr = new String[len];
            arr = br.readLine().split(" ");;
            int middle = ((arr.length % 2 == 0)? (arr.length / 2) : (arr.length / 2)+1) ;
            // q1.clear();q2.clear();
            result.clear();
            for(int i = 0 ; i < middle ; i++){
                    result.add( arr[i] );
                if (i < arr.length ){
                    result.add( arr[i+ middle] );
                }
            }
            // for(int i = 0; i < middle ; i++){
            //     q1.add(arr[i]);
            // }
            // for(int i = middle ; i < arr.length  ; i++){
            //     q2.add(arr[i]);
            // }
            // while ( !q1.isEmpty() || !q2.isEmpty() ){
            //     if (!q1.isEmpty()){
            //         result.add( q1.remove() );
            //     }
            //     if (!q2.isEmpty()){
            //         result.add( q2.remove() );
            //     }
            // }
            System.out.printf("#%d " , test);
            for(String str : result){
                System.out.printf("%s " , str);
            }
            System.out.println();
            

        }
    }
    
}
