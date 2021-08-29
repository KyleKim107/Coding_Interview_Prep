package Greedy;

import java.util.*;
import java.io.*;

public class BOJ2810 {
    public static void main(String[]z){
		Scanner s=new Scanner(System.in);
		int n=s.nextInt(),r=1,i=0; //마지막을 위해 하나를 붙여준다
		char[]a=s.next().toCharArray();
		for(;i<a.length;i++) { // 무조건 왼쪽에 하나를 붙인다는 생각 왜냐면 S든, LL이든 좌우 둘중에 하나밖에 못쓴다.
			if(a[i]=='L')i++; // L이뜨면 한칸을 더 옮겨줘
			r++;
		}
        System.out.println(r);
		System.out.print(r<n?r:n); // 만약 카운트 수가 n보다 작다면 카운트를 리턴, 만약 크다면 n리턴
	}
}
