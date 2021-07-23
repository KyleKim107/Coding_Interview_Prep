package Data_Structure.Deque;

import java.util.*;
// import java.util.*;
public class BOJ2164 {
    public static void main(String[] Args){
        Scanner scan =new Scanner(System.in);
		
        int N = scan.nextInt();
        int n =1;
        while(n<N)
            n*=2;
        System.out.println(n);
        n/=2;
        if( N ==1)
            System.out.println(1);
        else
            System.out.println((N-n)*2);
    }
}
