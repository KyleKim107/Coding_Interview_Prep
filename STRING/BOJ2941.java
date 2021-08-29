package STRING;

import java.util.*;
import java.io.*;

public class BOJ2941 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String croa=sc.nextLine().trim();
            croa=croa.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z="," "); // 자리 하나로 카운트
            System.out.println(croa.length());
          }  
}
