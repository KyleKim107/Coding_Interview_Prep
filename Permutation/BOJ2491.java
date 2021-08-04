package Permutation;

import java.util.Scanner;
import java.util.*;

public class BOJ2491 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
       
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        int len = 1;int maxV = 1;
        for (int i = 1; i < num; i++) {
            if (arr[i - 1] <= arr[i]) {
                len++;
                maxV = Math.max(len, maxV);
            }else{
                len = 1;
            }
        }
        len = 1;
        for (int i = 1; i < num; i++) {
            if (arr[i - 1] >= arr[i]) {
                len++;
                maxV = Math.max(maxV, len);
            }else{
                len = 1;
            }
        }
            System.out.println(maxV);
    }

}
