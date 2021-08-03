package Recursion;
import java.util.*;
import java.io.*;


import java.io.*;
public class BOJ17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion (0 , num);
        System.out.println("라고 답변하였지.");

        
    }

    public static void recursion (int barNum , int turn){
        if (turn == 0){
            for(int i = barNum ; i > 0 ; i--){
                System.out.print("____");
            }
            System.out.println("\"재귀함수가 뭔가요?\"");

            for(int i = barNum ; i > 0 ; i--){
                System.out.print("____");
            }
            System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
     
            return;
        }
        for(int i = barNum ; i > 0 ; i--){
            System.out.print("____");
        }
        System.out.println("\"재귀함수가 뭔가요?\"");
        for(int i = barNum ; i > 0 ; i--){
            System.out.print("____");
        }
        System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        for(int i = barNum ; i > 0 ; i--){
            System.out.print("____");
        }
        System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        for(int i = barNum ; i > 0 ; i--){
            System.out.print("____");
        }
        System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        recursion (barNum+1 , turn-1);

        for(int i = barNum+1 ; i > 0 ; i--){
            System.out.print("____");
        }
        System.out.println("라고 답변하였지.");
        return;
    }
    
}
