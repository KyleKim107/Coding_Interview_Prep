package Data_Structure.Stack;
import java.util.*;
import java.io.*;

public class SW5432 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Data_Structure/Stack/SW5432.txt"));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        for(int test_case = 1 ; test_case <= TC ; test_case++ ){
            String currStr = br.readLine();
            Stack<Character> st = new Stack<>();
            int total = 0;
            for(int i = 0 ; i < currStr.length() ; i++){
                char curr = currStr.charAt(i);
                if(curr == '('){
                    st.add(curr);
                }else if(curr == ')'){
                    st.pop();
                    if(currStr.charAt(i-1) == '('){
                        total += st.size(); // 레이져인 경우
                    }else{
                        total += 1; // 막대기의 끝
                    }
                }
            } // end of for-loop
            bw.write("#" +test_case + " " +total + "\n");
        }// end of testcase loop
        bw.flush();br.close();bw.close(); 
    }// end of main
}
