package simulation;

import java.util.*;
import java.io.*;

public class BOJ19236 {
    public static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
    public static int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
    public static int maxV = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ19236.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[] fishes = new Fish[17];
        Fish[][] arr = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = new Fish(i, j, Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()), false);
                fishes[arr[i][j].num] = arr[i][j];
                System.out.print(arr[i][j].num + " ");
            }
            System.out.println();
        }
        System.out.println();
        Fish shark = new Fish(0, 0, 0, arr[0][0].dir, true);
        fishes[arr[0][0].num] = null; // 하나가 삭제될때는 fish와 arr둘다 지우자
        arr[0][0] = shark;
        int total = arr[0][0].num;
        dfs(fishes, arr, total, 0, 0);

    }

    public static void dfs(Fish[] fishes, Fish[][] arr, int total, int x, int y) {
        // move
        for (int i = 1; i < 17; i++) {
            if (fishes[i] == null || fishes[i].shark)
                continue;

            Fish tmp = fishes[i];
            System.out.println(tmp.num);
            int currX = tmp.x, currY = tmp.y, dir = tmp.dir;
            int nextDir = nextDir(currX, currY, dir, arr, false);
            if (nextDir == -1)
                continue;

                
            int nx = currX + dx[nextDir], ny = currY + dy[nextDir]; // swapping
            tmp.x = nx; // tmp 재배치
            tmp.y = ny;
            tmp.dir = nextDir;

            if (arr[nx][ny] != null) { // 다른물고기가 있는경우
                Fish oppo = arr[nx][ny];
                oppo.x = currX;
                oppo.y = currY;
                fishes[oppo.num] = oppo;
                arr[currX][currY] = oppo;
            } else { // 다른물고기가 없는경우
                arr[currX][currY] = null;
            }
            fishes[tmp.num] = tmp;
            arr[nx][ny] = tmp;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j].num + " ");

            }
            System.out.println();
        }
        System.out.println();

        int sharkTurn = 8;
        Fish shark = arr[x][y];
        while(sharkTurn-- > 0){
            int nextDir = nextDir(x, y, arr[x][y].dir, arr, true), cnt = 0;
            while( true){
                int nx = x + dx[nextDir], ny = y+ dy[nextDir];
                if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
                if(arr[nx][ny] != null){ // 물고기가 있다
                    arr[x][y] = null; //만약 방향을 찾으면 자리를 비워줌
                    Fish fish = arr[nx][ny];
                    arr[nx][ny] = shark;
                    fishes[fish.num] = null;
                    dfs(fishes, arr,  total + fish.num , nx ,ny );
                    // arr[x][y] = shark; //만약 방향을 찾으면 자리를 비워줌
                    // arr[nx][ny] = fish;


                }
            }
            if(cnt > 0){ 
                break;
            }
            arr[x][y].dir = nextDir; // 그방향에 아무것도 없다면 방향을 바꾸고 다른방향 탐색
            //방향바꾸기
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j].num + " ");

            }
            System.out.println();
        }


        return;
        // hunt

    }

    public static int nextDir(int currX, int currY, int dir, Fish[][] arr, boolean shark) {
        int num = 8;
        while (num-- > 0) {
            int nx = currX + dx[dir], ny = currY + dy[dir]; // 처음 지금 방향을 고른다
            if (!shark && (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || arr[nx][ny].shark) ) {
                dir = dir + 1 > 8 ? 1 : dir + 1;
                continue;
            }else if (shark && (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 ) ){
                dir = dir + 1 > 8 ? 1 : dir + 1;
                continue;
            }
            return dir;

        }
        return -1;
    }

    public static int sharDir() {
        return 0;
    }

    static class Fish {
        int x, y, num, dir;
        boolean shark;

        public Fish(int x, int y, int num, int dir, boolean shark) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.shark = shark;
        }
    }

}
