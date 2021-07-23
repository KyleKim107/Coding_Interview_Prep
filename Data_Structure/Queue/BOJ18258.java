package Data_Structure.Queue;

import java.util.*;
import java.io.*;

public class BOJ18258 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> list = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			if(str.contains("push")) {
				int num = Integer.parseInt(str.substring(5));
				list.add(num);
			}else if(str.equals("front")) {
				sb.append(list.isEmpty() ?-1+"\n" : list.peekFirst()+"\n");
			}else if(str.equals("back")) {
				sb.append(list.isEmpty() ? -1+"\n"  : list.peekLast()+"\n");
			}else if(str.equals("size")) {
				sb.append(list.size()+"\n");
			}else if(str.equals("pop")) {
				sb.append(list.isEmpty() ? -1+"\n" : list.removeFirst()+"\n");
			}else if(str.equals("empty")) {
				sb.append(list.isEmpty()? 1+"\n" : 0+"\n"); 
			}
		}
		System.out.println(sb);
	}
}
