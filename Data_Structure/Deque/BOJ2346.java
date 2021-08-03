package Data_Structure.Deque;

import java.util.*;


import java.io.*;

public class BOJ2346 {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	
		LinkedList<Ballon> step = new LinkedList<Ballon>();		
		for(int i=1; i<n+1; i++)
			step.add(new Ballon(i,sc.nextInt())); //객체화 시키는것의 장점은, 제거 가능한것이다.
		
		int now = 0;
		int val = 0;
		for(int i=0; i<n; i++) {
			if(val > 0) {
				for(int j=0; j<val-1; j++) {
					now++;
					if(now >= step.size())
						now = 0;
				}
			}
			else if(val < 0) {
				val = val * -1; // 양수로 바꿈
				for(int j=0; j<val; j++) {
					now--;
					if(now < 0)
						now = step.size()-1;
				}
			}
			Ballon b = step.get(now);
			val = b.val;
			System.out.print(b.num+" ");
			step.remove(now); // 제거하니까 살아 있는지 죽은지 알 필요 없다
			if(now == step.size())
				now = 0;
		}						
	}
}

class Ballon{
	int num;
	int val;
	public Ballon(int n, int v) {
		num = n;
		val = v;
	}
}
    


