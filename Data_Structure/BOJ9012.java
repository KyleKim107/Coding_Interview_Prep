package Data_Structure;

import java.util.*;

public class BOJ9012 {
	public static void main(String[] rg) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0){ // decrement (--)  and compare with zero (>)
            String s = sc.next();
            while(s.contains("()")){ 
                s = s.replace("()", "");
            }
            System.out.println(s.equals("") ? "YES" : "NO");
        }
	}
}