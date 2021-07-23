package SWEA;
import java.util.*;
public class sw1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1; t <= test; t++) {
			String s = sc.next();
			int flag = 1;
			for(int i = 0; i < s.length()/2; i++) {
				if(s.charAt(i) != s.charAt(s.length()-1-i)) {
					flag = 0;
					break;
				}
			}
			System.out.println("#" + t + " " + flag);
		}
        
    }
}
