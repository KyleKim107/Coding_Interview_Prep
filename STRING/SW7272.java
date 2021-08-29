package STRING;
import java.util.*;
import java.io.*;
public class SW7272 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("STRING/SW7272.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        String[] same = new String[]{"C|E|F|G|H|I|J|K|L|M|N|S|T|U|V|W|X|Y|Z" ,"A|D|O|P|Q|R"};
        String[] convert = new String[]{"1" ,"2"};
        for(int test = 1 ; test <= TC ; test++ ){
            StringTokenizer str = new StringTokenizer(br.readLine());
            String A = str.nextToken();
            String B = str.nextToken();
            for(int i = 0 ; i < same.length ; i++ ){
                A =A.replaceAll(same[i], convert[i]);
                B =B.replaceAll(same[i], convert[i]);
            }

            boolean flag = true;
            if(A.length() == B.length() ){
                for(int i = 0 ; i < A.length() ; i++){
                    if(A.charAt(i) != B.charAt(i)){
                        flag = false;
                        break;
                    }
                }
                System.out.println("#" + test + ((flag)? " SAME": " DIFF"));
            }else{
                System.out.println("#" + test + " DIFF");
            }
        }

        
    }
    
}
