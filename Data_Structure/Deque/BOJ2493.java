package Data_Structure.Deque;
import java.util.*;
import java.io.*;

class Pair{
    int index;
    int value;
    public Pair(int index , int value){
        this.index = index;
        this.value = value;
    }
}

public class BOJ2493 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        String tmp = br.readLine();
        Stack<Pair> st = new Stack<>();
        int i = 0 ;
        for(String str : tmp.split(" ")){
            arr[i++] = Integer.parseInt(str);
        }
        for(i = 0 ; i < arr.length ; i++){
            int curr = arr[i];
            while(! st.isEmpty()){
                if(st.peek().value >= curr){ // 스택안에 있는 값이 자기보다 크면 peek()으로 인덱스를 출력하고 룹을 나간다 
                                            // 현재 값에서 만약 스택 안에 있는 값이 자신보다 작으면 뺸다
                    System.out.print(st.peek().index + " ");
                    break;
                }
                st.pop(); // 만약 스택에 있는 값이 현재값 보다 크다면 스택에서 뺴지 않는다
            }
            if(st.isEmpty()){
                System.out.print(0 + " ");
            }
            st.push(new Pair( i +1 , curr )); // 현재값은 무조건 넣어지게 되어 있다
        }
    }
}
