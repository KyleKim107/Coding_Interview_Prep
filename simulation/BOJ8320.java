package simulation;
import java.util.*;
import java.io.*;
public class BOJ8320 {
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		for(int i=1; i<=n; i++) {
			for(int j=i; i*j<=n; j++) {
				count ++;
			}
		}
		System.out.println(count);
		scan.close();
	}
}
