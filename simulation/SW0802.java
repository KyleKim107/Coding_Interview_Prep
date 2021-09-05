package simulation;
import java.util.*;
import java.io.*;
public class SW0802 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/SW0802.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= TC ; test++ ){
             String str =br.readLine();
             char v = '0'; int cnt = 0;
             for(int i = 0 ; i < str.length() ; i++){
                 char tmp = str.charAt(i);
                 if(tmp != v){
                    v = tmp;
                    cnt ++;
                 }
             }
             System.out.println("#" + test + " "+cnt);
        }

    }
    
}
