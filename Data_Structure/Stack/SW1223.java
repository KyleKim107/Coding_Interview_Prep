package Data_Structure.Stack;

import java.util.*;
import java.io.*;

public class SW1223 {
    public static String convert(char[] arr) {
        String answer = "";
        Stack<Character> cha = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // System.out.println("arr[i] : " +arr[i]);
            // System.out.println(cha);
            // System.out.println(answer);
            char tmp = arr[i];
            if (0 <= arr[i] - '0' && arr[i] - '0' <= 9) {
                //2+3*4*5+6+7
                //234*5*+6+7+
                answer += arr[i];
            } else {
                if (cha.isEmpty()) {
                    cha.add(arr[i]);
                    continue;
                } else {
                    if(cha.isEmpty()){
                        cha.add(arr[i]);
                    }else if (arr[i] == '+') {
                        while (!cha.isEmpty()) {
                            answer += cha.pop();
                        }
                        cha.add(arr[i]);
                    } else if (arr[i] == '*') {
                        if (cha.peek() == '+') {
                            cha.add(arr[i]);
                        }else if(cha.peek() == '*') {
                            while((!cha.isEmpty() && cha.peek() == '*')){
                                answer += cha.pop();
                            }
                            cha.add(arr[i]);
                        }
                    }
                }
            }
        }
        while (!cha.isEmpty()) { //234*5*+6+7+
            answer += cha.pop();
        }
        // System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Data_Structure/Stack/SW1223.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test = 1; test <= 10; test++) {
            int N = Integer.parseInt(br.readLine());
            char[] arr = new char[N];
            arr = br.readLine().toCharArray();
            arr = convert(arr).toCharArray();
            Stack<Integer> st = new Stack<Integer>();
            
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                if (0 <= arr[i] - '0' && arr[i] - '0' <= 9) {
                    st.add(arr[i] - '0');
                }else{
                    int back = st.pop();
                    int front = st.pop();
                    if(arr[i] == '+'){
                        st.add(front+back);
                    }else{
                        st.add(front*back);
                    }
                }
            }
            System.out.println("#" + test+ " "+ st.pop());
        }
    }
}

// #1 28134
// #2 195767
// #3 4293
// #4 1592
// #5 477326
// #6 45647
// #7 102951
// #8 6548
// #9 1394
// #10 4285
