package SWEA;
import java.util.*;

public class sw1979ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test = 0 ; test < tc ; test++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][n];
            int[] store = new int[n+1];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int cnt = 0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(arr[i][j] == 0){
                        store[cnt] += 1;
                        cnt = 0;
                    }else{
                        cnt++;
                    }
                }
                store[cnt]++;
                cnt = 0;
                // 사실상 store[0]는 더미로 값이 어떻게 되든 큰 상관이 없다
                // 만약 한 행의 마지막 세개가 연속되어 있다면, inner forloop이 끝나고 값을 sotre안에 저장된다
            }
            System.out.println(Arrays.toString(store));
            cnt = 0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(arr[j][i] == 0){
                        store[cnt] += 1;
                        cnt = 0;
                    }else{
                        cnt++;
                    }
                    }
                    store[cnt]++;
                    cnt = 0; 
                }
            System.out.printf("#%d %d" , test+1,store[k]);


        }
    }
}
