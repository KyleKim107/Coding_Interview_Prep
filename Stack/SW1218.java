package Stack;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.*;
import java.io.*;


public class SW1218 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in)) ;
        int len = Integer.parseInt( br.readLine() );
        char[] arr = new char[len];
        arr = br.readLine().toCharArray(); // (({<(({
        Stack<Character> st = new Stack<Character>();
        for(int i = 0 ; i < len; i++){

            
            if("({[<".contains(String.valueOf(arr[i]))){
                st.push(arr[i]);
            }


            if(arr[i] == ')' && st.peek() == '(') {
                st.pop();
            }else if(arr[i] == ']'&& st.peek() == '[') {
                st.pop();
            }else if(arr[i] == '}'&& st.peek() == '{') {
                st.pop();
            }else if(arr[i] == '>'&& st.peek() == '<') {
                st.pop();
            }else{
                break;
            }


        }
        System.out.printf("%d", ((st.isEmpty())?1:0));
    }
}
