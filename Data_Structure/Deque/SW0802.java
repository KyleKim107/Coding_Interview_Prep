package Data_Structure.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.*;


public class SW0802 {

    public static boolean checker(char[] arr1, char[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            int result = 0;
			char[] sample = br.readLine().toCharArray();
            char[] compare = new char[sample.length];
            for(int j = 0 ; j < sample.length ; j++){
                compare[j] = '0';
            }
            int curr = 0;
            while (curr < sample.length) {
                if (!checker(sample, compare)) {
                    if (sample[curr] != compare[curr]) {
                        result += 1;
                        for (int j = curr; j < sample.length; j++) {
                            compare[j] = sample[curr];
                        }
                    }
                } else {
                    break;
                }
                curr += 1;
            }
            System.out.printf("#%d %d\n" , i+1, result);
		}
    }
    }


