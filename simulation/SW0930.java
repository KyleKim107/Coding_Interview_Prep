package simulation;
import java.util.*;
import java.io.*;
public class SW0930 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/SW0930.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= TC ; test++ ){
            int rotateNum = Integer.parseInt(br.readLine()), answer = 0;
            arr = new int[4][8];
            StringTokenizer str = null;
            for(int i = 0 ; i < 4 ; i++ ){
                str = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < 8 ; j++ ){
                    arr[i][j]=Integer.parseInt(str.nextToken());
                }
            }
            for(int i = 0 ; i < rotateNum ; i++ ){
                str = new StringTokenizer(br.readLine());
                int gearNum = Integer.parseInt(str.nextToken()) -1 ,dir = Integer.parseInt(str.nextToken());
                int[] gearDIR = new int[4];
                gearDIR[gearNum] = dir;
                for(int z = gearNum-1 ; z >= 0 ; z-- ){ // 2 VS 6
                    if(arr[z][2] != arr[z+1][6] )gearDIR[z] = gearDIR[ z + 1 ] * -1;
                    else break;
                }
                for(int z = gearNum+1 ; z < 4  ; z++ ){ // 2 VS 6
                    if( arr[z-1][2] != arr[z][6] ) gearDIR[z] = gearDIR[ z -1 ] * -1;
                    else break;
                }

                for(int j = 0 ; j < 4 ; j++ ){
                    if(gearDIR[j] == 0) continue;
                    if(gearDIR[j] == 1) rotate( j , 1);
                    else if(gearDIR[j] == -1) rotate( j , -1);
                }
            }
            for(int index = 0 ; index < 4 ; index++ ){
                if(arr[index][0] == 1) answer += Math.pow(2, index);
            }
            System.out.println("#" + test + " " + answer);
        }
    }
    public static void rotate(int index , int dir ){
        if( dir == 1){
            int tmp = arr[index][7];
            for(int i = 6 ; i >= 0 ; i-- ){
                arr[index][i+1] = arr[index][i];
            }
            arr[index][0] = tmp;
        }else{
            int tmp = arr[index][0];
            for(int i = 1 ; i < 8 ; i++ ){
                arr[index][ i -1 ] = arr[index][ i ];
            }
            arr[index][7] = tmp;
        }
    }
}
