package Data_Structure.Deque;



import java.io.*;
public class SW0802Prof {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < T ; t++){
            int ans = 0; 
            char[] arr = br.readLine().toCharArray();
            char prev = '0';
            for(char c : arr){
                if(c !=prev){
                    ans++;
                    prev = c;
                }
            }
            System.out.println("#" + t+1 + " "+ ans);

        }
    }
}
