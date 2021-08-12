package simulation;
import java.util.*;
import java.io.*;


public class BOJ17406 {
    public static int[] dx = { 1, 0, -1, 0 }; // 밑, 우 , 상, 좌
    public static int[] dy = { 0, 1, 0, -1 };
    public static int[][] arrA ;
    public static NumSet[] nums;
    public static int N, M,R ,minV = Integer.MAX_VALUE ;

    public static void func(int[] visit, NumSet[] numset , int currIndex){
        if(currIndex == R){// 실행
            int[][] arrB = new int[N][M];
            for(int i = 0 ; i < N; i++){
                arrB[i] = Arrays.copyOf(arrA[i], arrA[i].length);
            }
            turn(numset, arrB);
            return;
        }

        for(int i = 0 ; i < R ; i++){
            if(visit[i] == 0){
                visit[i] = 1;
                numset[currIndex] = nums[i];
                func(visit, numset , currIndex+1);
                numset[currIndex] = null;
                visit[i] = 0;
            }
        }
    }

    public static void turn(NumSet[] numset , int[][] arrB ){
        for(int i = 0 ; i < numset.length ; i++){
            NumSet curr = numset[i];
            int r = curr.r , c = curr.c , s = curr.s;
            int leftX = r-s, leftY = c-s,rightX = r+s, rightY = c+s;
            int currN = rightX -leftX +1, currM = rightY -leftY +1;
            int startX = leftX -1, startY = leftY -1;
            int len = Math.min(currN ,currM) /2;
            for(int index = 0 ; index < len ; index++){
                int tmp = arrB[startX + index][startY+ index];
                int x = startX+ index;
                int y = startY+ index;
                for(int dir = 0 ; dir < 4 ; dir++){
                    while(true){
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        int limitX =startX + currN , limitY = startY + currM;
                        if( nx< startX + index || nx >= (limitX) - index || ny < startY + index || ny >= (limitY) -index ){
                            break;
                        }
                        arrB[x][y] = arrB[nx][ny];
                        x = nx;
                        y = ny;
                    }
                }
                arrB[startX + index][startY+ index + 1] = tmp;
            }
        }
        for(int i = 0 ; i < N ; i++){
            int cnt = 0;
            for(int j = 0 ; j < M ; j++){
                cnt += arrB[i][j];
            }
            minV = Math.min(cnt, minV);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ17406.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());M = Integer.parseInt(str.nextToken());R = Integer.parseInt(str.nextToken());
        arrA = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arrA[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        nums = new NumSet[R];
        int[] visit = new int[R];
        for(int r = 0 ; r < R ; r++){
            str = new StringTokenizer(br.readLine());
            nums[r] = new NumSet(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
        }
        NumSet[] numset = new NumSet[R];

        func(visit , numset , 0) ;
        System.out.println(minV);
    }
}


class NumSet{
    int r,c,s;
    NumSet(int r, int c ,int s){
        this.r =r;
        this.c =c;
        this.s =s;
    }
}