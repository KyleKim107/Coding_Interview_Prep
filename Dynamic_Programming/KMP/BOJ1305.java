package Dynamic_Programming.KMP;
import java.util.*;
import java.io.*;
public class BOJ1305 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Dynamic_Programming/KMP/BOJ1305.txt"));
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt( br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[] pi = new int[arr.length];
        for(int i = 1, j = 0 ; i < arr.length ; i++ ){
            while(j > 0 && arr[i] != arr[j]){
                j = pi[j-1];
            }
            if(arr[i] == arr[j]){
                pi[i] = ++j;
            }
        }
        
        System.out.println(N - pi[arr.length-1]);

    }
    
}
