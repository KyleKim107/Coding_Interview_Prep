package Recursion;
import java.util.*;
import java.io.*;
public class SW1223 {
    static int result = 0;
	public static void main(String []args) throws Exception {  
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	for(int test_case = 1; test_case <= 10; test_case++) {
    		char nextNum;
    		int n = Integer.parseInt(br.readLine());
    		int valid = 1;
    		for(int i = 1; i <= n; i++){
    			st = new StringTokenizer(br.readLine());
    			st.nextToken(); // graph number
        
    			nextNum = st.nextToken().charAt(0);
                System.out.println("curN : " + nextNum);
                
    			if(st.hasMoreTokens()) {	// 리프노드들은 3,4번째 토큰이 없다
    				if( '0' <= nextNum && nextNum <= '9' ) {	// 숫자인 경우, 유효성이 옳지 않다
    					valid= 0;
    				}
    			}
    			else {						// 단말 노드 일 때, 숫자가 있어야 한다.
    				if(nextNum < '0' || '9' < nextNum ) {		// 숫자가 아닌 경우, 유효성이 옳지 않다
    					valid= 0;
    				}
    			}
    		}
    		System.out.println("#" + test_case + " " + valid);
    	}
    	
	}

}
