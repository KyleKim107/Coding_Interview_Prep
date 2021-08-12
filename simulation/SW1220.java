package simulation;

import java.io.*;
import java.util.*;

class Magnet{
    int num;
    int x;
    int y;
    int live = 1;
    public Magnet(int num, int x , int y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

public class SW1220 {
    public static int[][] arr;
    public static int[] dx = { 0, 1, -1 };
    public static int cnt = 0, N;

    public static boolean mutuable(int j, int k) {
        // 아랫 방향에 S극이 있는지 확인할 것
        j++;
        while(j < N) {
            if(arr[j][k] == 1) {
                // N극이 또 있으면 skip
                return false;
            }
            if(arr[j][k] == 2) {
                return true;
            }
            j++;
        }
        return false;
    }

    // public static int[] dy ={0,0,0};

    public static Magnet move(Magnet magnet) {
        int num =magnet.num,  x =magnet.x,  y =magnet.y;
        int nx = x + dx[num];
        if (0 <= nx && nx < arr.length && arr[nx][y] == 0) {
            arr[nx - dx[num]][y] = 0;
            arr[nx][y] = num;
            magnet.x = nx;
            cnt += 1;
        }else if (!(0 <= nx && nx < arr.length)) {
            arr[nx - dx[num]][y] = 0;
            magnet.live = 0;
            cnt += 1;
        }
        return magnet;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/SW1220.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            Queue<Magnet> Q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int currNum = Integer.parseInt(str.nextToken());
                    if (currNum != 0){
                        arr[i][j] = currNum;
                        Q.add(new Magnet(currNum, i, j));
                    }
                }
            }
            while (true) {
                cnt = 0;
                int len = Q.size();
                for(int i = 0 ; i < len ; i++){
                    Magnet magnet = Q.remove();
                    magnet = move(magnet);
                    if(magnet.live != 0){
                        Q.add(magnet);
                    }
                }
                if (cnt == 0){
                //     System.out.println();
                // for (int k = 0; k < N; k++) {
                //     System.out.println(Arrays.toString(arr[k]));
                // }
                // System.out.println();
                    break;
                }
            }int result = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(arr[j][k] == 1) {
                        // N극인 위치에서 시작
                        if(mutuable(j, k)) {
                            // 아랫방향에 S극이 있는가?
                            result++;
                        }
                    }
                }
            }
            System.out.println(result);

        }
        br.close();
    }
}
// 15
// 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
// 2 2 0 0 0 0 2 0 0 0 0 0 0 0 0
// 1 1 0 0 1 0 1 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0


// 7
// 1 0 2 0 1 0 1
// 0 2 0 0 0 0 0
// 0 0 1 0 0 1 0
// 0 0 0 0 1 2 2
// 0 0 0 0 0 1 0
// 0 0 2 1 0 2 1
// 0 0 1 2 2 0 2
