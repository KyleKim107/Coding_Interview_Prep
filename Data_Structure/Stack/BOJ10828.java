package Data_Structure.Stack;
import java.util.*;

public class BOJ10828 {  // 출력을 바꿔서 속도 비교
    public static void main(String[]V) {
		Scanner S = new Scanner(System.in);
		Stack<Integer> A = new Stack<>();
		for(int T = S.nextInt(); T > 0; T--) {
			String s = S.next();
			if(s.equals("push"))
				A.push(S.nextInt());
			if(s.equals("pop"))
				System.out.println( A.isEmpty()? -1 : A.pop() );
			if(s.equals("size"))
				System.out.println(A.size());
			if(s.equals("empty"))
				System.out.println(A.isEmpty()?1:0);
			if(s.equals("top"))
				System.out.println(A.isEmpty()?-1:A.peek());
		}
	}
}
