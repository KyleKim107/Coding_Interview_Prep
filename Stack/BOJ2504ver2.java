package Stack;

import java.util.*;
import java.io.*;

public class BOJ2504ver2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 1; int result = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            Character c  = str.charAt(i);


            if(st.isEmpty() ){
                if( str.charAt(i) =='(' ){
                    st.add( c );
                    cnt  =2 ;
                }else if(str.charAt(i) =='[' ) {
                    st.add( c );
                    cnt  = 3;
                }
            }else{
                if( str.charAt(i) =='(' ){
                    st.add( c );
                    cnt  *= 2 ;
                }else if(str.charAt(i) =='[' ) {
                    st.add( c );
                    cnt  *= 3;
                }

                if(str.charAt(i) ==')'){
                    if(st.isEmpty() || str.charAt(i-1) != '('){
                        result = 0;
                        break;
                    }
                    if (str.charAt(i-1)== '('){
                        result += cnt;
                    }
                    cnt /= 2;
                        st.pop();

                }else if( c ==']'){
                    if(st.isEmpty() || str.charAt(i-1) != '('){
                        result = 0;
                        break;
                    }
                    if (str.charAt(i-1)== '['){
                        result += cnt;
                }
                cnt /= 3;
                st.pop();

                }

            }
        }
        if (st.isEmpty()){
            System.out.println(result);
    }else{
        System.out.println(0);
    }

    }

}
