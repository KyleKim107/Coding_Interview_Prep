package Sort;

import java.util.*;

public class BOJ10814 {
    public static void main(String[] z){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] list = new String[N][3];
        for( int i = 0 ; i< N ; i++){
            list[i][0] = sc.next();
            list[i][1] = sc.next();
        }
        Arrays.sort(list, (s1, s2) -> {
			    return Integer.compare(Integer.parseInt(s1[0]), Integer.parseInt(s2[0]));
		    }
        );
        for( int i = 0 ; i < N ; i++){
            System.out.println(Arrays.toString(list[i]));
        }
    }
    
}
