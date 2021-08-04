package simulation;

import java.util.*;

public class BOJ1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        int Snum = sc.nextInt();
        for(int i = 0 ; i < Snum ; i++){
            int gen = sc.nextInt(), num = sc.nextInt();
            if (gen == 1){
                for(int j = 1 ; j < (arr.length / num)+1 ;j++){
                    arr[num * j -1] ^= 1;
                }
            }else{
                arr[num -1 ] ^= 1;
                for(int j = 1; j < (arr.length / 2) ; j++){
                    if( 0 <= num -1 -j   && num -1 +j < N  &&  arr[num -1 -j] == arr[num -1 +j] ){
                        arr[num -1 -j] ^= 1;
                        arr[num -1 +j] ^= 1;
                    }else{
                        break;
                    }
                }
            }
        }
        for(int z = 0 ; z < arr.length ; z++){
            System.out.print(arr[z] + " ");
            if( z % 20 == 19){
                System.out.println();
            }
        }
    }
}
