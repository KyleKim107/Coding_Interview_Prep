package Brute_Force;
import java.io.*;
import java.util.*;
public class BOJ1463 {
    public static void main(String[]Z) {
		int N = new Scanner(System.in).nextInt(), D[] = new int[N+1];
		for(int i =1; i++ < N;) {
            System.out.println(i);
			D[i] = D[i-1]+1;
			D[i] = i%2==0 ? Math.min(D[i],D[i/2]+1) : D[i];
			D[i] = i%3==0 ? Math.min(D[i],D[i/3]+1) : D[i];
		}
		System.out.print(D[N]);
	}
}
