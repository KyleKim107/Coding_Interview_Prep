package STRING;

import java.util.*;
import java.io.*;

public class BOJ17413 {
    public static int[] dx = { 0, -1, 1, 0, 0 }, dy = { 0, 0, 0, 1, -1 };
    public static int[] sharkTurn = { 0, 2, 1, 4, 3 };
    public static int R, C, M, answer = 0;;
    public static Shark[][] arr;
    public static ArrayList<Shark> sharkList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new Shark[R][C];
        sharkList = new ArrayList<>();
        int FisherCol = -1;
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(str.nextToken()) - 1, c = Integer.parseInt(str.nextToken()) - 1,
                    s = Integer.parseInt(str.nextToken()), d = Integer.parseInt(str.nextToken()),
                    z = Integer.parseInt(str.nextToken());
            Shark tmp = new Shark(r, c, s, d, z);
            arr[r][c] = tmp;
            sharkList.add(tmp);
        }

        while (FisherCol++ < C - 1) {
            hunt(FisherCol);

            move(); // 상어 움직이기
            // alloc
            kill();
        }
        System.out.println(answer);
    }

    public static void kill() {
        for (int i = sharkList.size() - 1; i >= 0; i--) {
            if(sharkList.get(i) == null) continue;
            Shark tmp = sharkList.get(i);
            if (arr[tmp.x][tmp.y] == null) {
                arr[tmp.x][tmp.y] = tmp;
            } else {
                if (arr[tmp.x][tmp.y].z > tmp.z) {
                    sharkList.remove(tmp);
                } else {
                    sharkList.remove(arr[tmp.x][tmp.y]);
                    arr[tmp.x][tmp.y] = tmp;
                }
            }
        }
    }

    public static void hunt(int FisherCol) {
        for (int i = 0; i < R; i++) {
            if (arr[i][FisherCol] != null) {
                answer += arr[i][FisherCol].z;
                sharkList.remove(arr[i][FisherCol]);
                arr[i][FisherCol] = null;
                break;
            }
        }
    }

    public static void move() {
        for (Shark tmp : sharkList) {
            int turn = tmp.s, dir = tmp.d, x = tmp.x , y = tmp.y;
            arr[x][y] = null;
            while (turn-- > 0) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    dir = sharkTurn[dir];
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }
            tmp.d = dir; tmp.x = x;  tmp.y = y;
        }
    }

    static class Shark {
        int x, y, s, d, z;// s는 속력, d는 이동 방향, z는 크기이다

        public Shark(int x, int y, int s, int d, int z) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}