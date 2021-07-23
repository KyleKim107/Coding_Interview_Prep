package Data_Structure.Stack;

import java.util.*;

public class BOJ2504 {

    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Stack<Character> St = new Stack<Character>();
		String str = sc.nextLine();

		int sum=1;
		int result=0;


		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			switch(c) {

			case '(':
				St.push('(');
				sum=sum*2;
				break;

			case ')':
				if(St.isEmpty()||St.peek()!='(') { // 괄호를 닫아야 하는데 스택이 비워져 있으면 안된다
					result=0;
                    System.out.println("yes");
					break;
				}

				if(str.charAt(i-1)=='(') // 닫을건데 인풋 스트링 바로 옆에 닫혀 있다면 result 값에 썸을 더해줘
					result+=sum; // 분산식으로 값을 곱해준다 예를 들어 (() 여기까지의 값은 4

				sum/=2; // 값을 하나 끝냈으니 하나를 뺴줘
				St.pop(); // ( 팝
				break;

			case '[':
				St.push('[');
				sum=sum*3;
				break;
			case ']':
				if(St.isEmpty()||St.peek()!='[') { // 닫을건데 스택이 옆에 닫혀 있거나 값에 [아니면 안된다
					result=0;
                    System.out.println("yes");

					break;
				}

				if(str.charAt(i-1)=='[')
					result+=sum;

				sum/=3;
				St.pop();
				break;

			}
		}	
	
		System.out.println(!St.isEmpty()? 0:result);
	}
}
