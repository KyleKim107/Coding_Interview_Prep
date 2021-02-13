import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();;
      int M = sc.nextInt();;
      int K = sc.nextInt();;
      Integer[] a =  new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
      Arrays.sort(a, Collections.reverseOrder());
    //   System.out.print(Arrays.toString(a));
      int cnt = 0;
      int total = 0;
      for(int i =0;i < M ;i ++){
          if (cnt == K){
              total += a[1];
              cnt = 0;
          }else{
                cnt += 1;
                total += a[0];
          }
      }
    System.out.println(total);
      
    }
}