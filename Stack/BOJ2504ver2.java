package Stack;

import java.util.*;
import java.io.*;

public class BOJ2504ver2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader( new InputStreamReader(System.in) );
        String str = br.readLine();
        int cnt = 1; int result = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            Character c  = str.charAt(i);
            if ( c == '('){
                st.add(c);
                cnt *= 2;
            }
            if ( c == '['){
                st.add(c);
                cnt *= 3;
            }
            if ( c == ')'){
                if(st.isEmpty() || st.peek() != '('){ // 스택이 비워져 있거나, 스텍의 윗부분이 짝이 안맞을경우
                    result = 0;
                    break;
                }
                if( str.charAt(i-1) == '(' ){
                    result += cnt;
                }
                st.pop();
                cnt /= 2;
            }

            if ( c == ']'){
                if(st.isEmpty() || st.peek() != '['){
                    result = 0;
                    break;
                }
                if( str.charAt(i-1) == '[' ){
                    result += cnt;
                }
                st.pop();
                cnt /= 3;
            }
        }
        if(st.isEmpty()){
        System.out.println(result);
    }else{
        System.out.println(0);
    }
    }

}
