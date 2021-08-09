package Data_Structure.Deque;
import java.io.*;
import java.util.*;

class Pair2{
    int index;
    int value;
    public Pair2(int index , int value){
        this.index = index;
        this.value = value;
    }
}

public class BOJ2493ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
		}
        Stack<Pair2> st = new Stack<>();
        for(int i = 0 ; i < num ; i++){
            int curr = arr[i];

            while(!st.isEmpty()){
                if(st.peek().value >= curr){
                    System.out.print(st.peek().index + " ");
                    break;
                }
                st.pop();

            }
            
            if(st.isEmpty()){
                System.out.print(0 + " ");
            }

            st.push(new Pair2(i +1 , curr));

        }

    }
}
