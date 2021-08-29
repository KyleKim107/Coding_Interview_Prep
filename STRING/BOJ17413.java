package STRING;

import java.util.*;
import java.io.*;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("STRING/BOJ17413.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        StringBuilder answer = new StringBuilder();
        StringBuilder tmp =new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') { 
                answer.append(tmp.reverse()); // <를 만나면 지금까지 저장한 단어를 반대로 한다음 저장한다
                tmp = new StringBuilder(); // 비워준다
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == '>') {
                        answer.append("<").append(str.substring(i+1, j)).append(">");
                        i = j;//i의  위치를 j다음으로 옮겨준다
                        break;
                    }
                }
            }else if(str.charAt(i) == ' '){
                answer.append(tmp.reverse()).append(" "); //공백이면 뒤직어 넣어주기
                tmp = new StringBuilder();
            }else{
                tmp.append(str.charAt(i)); // 일반 문자면 저장해주기
            }
        }
        if( str.charAt(str.length()-1) != '>' ){
            answer.append(tmp.reverse());
        }
        System.out.println(answer);
    }
}