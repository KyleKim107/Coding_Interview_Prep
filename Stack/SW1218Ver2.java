package Stack;
import java.util.*;
import java.io.*;
public class SW1218Ver2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		outer: for (int t = 1; t <= 10; t++) {
			Integer.parseInt(br.readLine());  // N
			char[] arr = br.readLine().toCharArray();
			Stack<Character> s = new Stack<>();
			for (char ch : arr) {
				if ("([{<".contains(String.valueOf(ch))) {
					s.push(ch);
					continue;
				} 
				// 닫는 괄호인 경우
				if (s.isEmpty() || ")]}>".indexOf(ch) != "([{<".indexOf(s.pop())) {
                    // 닫아야 하는데 비워있으면 에러
                    // 닫히는 괄호와 열리는 괄호가 다르면
					System.out.println("#" + t + " 0");
					continue outer;
				}
                System.out.println(s);
			}
			if (s.isEmpty()) System.out.println("#" + t + " 1");
			else             System.out.println("#" + t + " 0");
		}
	}
}
