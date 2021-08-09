package Data_Structure.Queue;
import java.util.*;
import java.io.*;

public class SW1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 8; test_case++){

        int len = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        String tmp = br.readLine();
        for(String str : tmp.split(" ")){
            q.add(  Integer.parseInt(str) );
        }
        int minor = 1;
        while (true){
            int num = q.remove();
            if ((num-minor)<= 0){
                q.add(0);
                break;
            }
            q.add(num-minor);
            minor += 1;
            if(minor % 6 == 0){minor = 1;}
        }
        System.out.printf("#%d " , test_case);
        for(int i : q){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    }

}
