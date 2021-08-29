package STRING;
import java.util.*;
import java.io.*;
public class BOJ2941ver2 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("STRING/BOJ2941.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = new String(br.readLine());
        str = str.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=" , " ");
        System.out.println(str);
        System.out.println(str.length());

        
    }

    
}
