import java.util.*;
import java.io.*;

public class SW8458 {
    public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int test = 1; test <= tc; test++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int sum=0, cnt=0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[0]= Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
			int max=arr[0];
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i]= Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
			}
            System.out.println("#" + test + " " + cnt);	
		}
	}
	
}
