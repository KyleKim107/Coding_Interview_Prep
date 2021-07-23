package Stack;
import java.util.*;

public class BOJ2504 {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<Character> st = new Stack<>();
        int curr = 1;
        int result = 0;
        for(int i = 0 ; i < input.length() ; i++){
            Character tmp = input.charAt(i);

            if (tmp == '('  ){
                st.push(tmp);
                curr *= 2;
            }else if(tmp == '[') {
                st.push(tmp);
                curr *= 3;
            }else if(tmp == ')' ){
                if(st.isEmpty() || st.peek() != '('){
                    result = 0;
                    break;
                }
                if(input.charAt(i-1) == '('){
                    result += curr;
                }
                st.pop();
                curr /= 2;
            }else if( tmp == ']' ){
                if(st.isEmpty() || st.peek() != '['){
                    result = 0;
                    break;
                }
                if(input.charAt(i-1) == '['){
                    result += curr;
                }
                st.pop();
                curr /= 3;
            }
        }
        System.out.println(!st.isEmpty()? 0:result);
    }
}



// package Stack;

// import java.util.*;

// public class BOJ2504 {
//     public static void main(String[] Args){
//         Scanner sc = new Scanner(System.in);
//         String input = sc.nextLine();
//         Stack<Character> st = new Stack<Character>();

//         int curr = 1;
//         int result = 0;

//         for(int i = 0 ; i < input.length() ; i++){
//             Character tmp = input.charAt(i);
//             switch(tmp) {

//             case '(':
//                 st.push('(');
//                 curr *= 2;
//                 break;
//             case '[':
//                 st.push('[');
//                 curr *= 3;
//                 break;
//             case ')':
//                 if(st.isEmpty() || st.peek() != '('){
//                     result = 0;
//                     break;
//                 }
//                 if(input.charAt(i-1) == '('){
//                     result += curr;
//                 }
//                 st.pop();
//                 curr /= 2;
//                 break;
//             case ']':
//                 if(st.isEmpty() || st.peek() != '['){
//                     result = 0;
//                     break;
//                 }
//                 if(input.charAt(i-1) == '['){
//                     result += curr;
//                 }
//                 st.pop();
//                 curr /= 3;
//                 break;
//             }
//         }
// 		System.out.println(!St.isEmpty()? 0:result);
//     }
// }
