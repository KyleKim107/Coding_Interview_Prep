package simulation;
import java.util.*;
import java.io.*;
public class SW5356 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("simulation/SW5356.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= TC ; test++ ){
            char[][] arr= new char[5][];
            int maxLen = Integer.MIN_VALUE;
            for(int i = 0 ; i < 5 ; i++ ){
                arr[i] = br.readLine().toCharArray();
                maxLen = Math.max(maxLen, arr[i].length);
                // System.out.println(Arrays.toString(arr[i]));
            }
            StringBuilder str = new StringBuilder("#" + test + " ");
            for(int i = 0 ; i < maxLen ; i++ ){
                for(int j = 0 ; j < 5 ; j++ ){
                    if(arr[j].length > i ){
                        str.append(arr[j][i]);
                    }
                }
            }
            System.out.println(str.toString());
        }
    }
}
