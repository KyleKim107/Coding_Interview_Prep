package SWEA;
import java.util.*;
import java.io.*;
public class SW1974 {
    public static void main(String[] args) throws IOException{
        
        System.setIn(new FileInputStream("SWEA/SW1974.txt"));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer str = null;
        int flag = 1;
        for(int test = 0 ; test< N ; test++){
            int[][] arr= new int[9][9];
            for(int i = 0 ; i < 9 ; i++){
                str = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < 9 ; j++){
                    arr[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            for(int i = 0 ; i < 9 ; i+= 3){
                for(int j = 0 ; j < 9 ; j+=3){
                    int[] squre = new int[9];
                    // 네모
                    for(int i2 = i ; i2 < i+3 ; i2++){
                        for(int j2 = j ; j2 < j+3 ; j2++){
                            squre[arr[i2][j2]-1] +=1;
                        }
                    }
                    System.out.println(Arrays.toString(squre));
                    // for(int i2 = i ; i2 < i+3 ; i2++){
                    //     for(int j2 = j ; j2 < j+3 ; j2++){
                    //         squre[arr[i2][j2]-1] +=1;
                    // }


                }
            }
            





        }
        
    }
}
