package Graph.BFS;
import java.util.*;
import java.io.*;
public class BOJ17144ver2 {
    public static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    public static Queue<Node> dust;
    public static int N, M;
    public static Node[] cleanear = new Node[2] ;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/BFS/BOJ17144.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken()); M = Integer.parseInt(str.nextToken());
        int T = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                if (arr[i][j] == -1){
                    if(cleanear[0] == null){
                        cleanear[0] = new Node(i,j,0);
                    }else{
                        cleanear[1] = new Node(i,j,0);
                    }
                }
            }
        }

        while (T-- > 0) {
            collect();
            spread();
            rotate();
        }

        int cnt = 0; // 정답 카운트
        for(int i = 0 ; i < N ; i++ ){
            for(int j = 0 ; j < M ; j++ ){
                if(arr[i][j] > 0 ) cnt += arr[i][j];
            }
        }
        System.out.println(cnt);
    }

    static void collect() { // 돌려주면서 판이 바꼈기 때문에 다시 넣어준다
        dust = new LinkedList<Node>();
        for(int i = 0 ; i < N ; i++ ){
            for(int j = 0 ; j < M ; j++ ){
                if(arr[i][j] > 0){
                    dust.offer(new Node(i , j , arr[i][j] /5  ));
                }
            }
        }
    }

    static void spread() {
        while(!dust.isEmpty()) {
            Node tmp = dust.poll();
            int currDust = tmp.spread , currCnt = 0;
            for (int dir = 0; dir < 4; dir++) {
                int nx = tmp.x + dx[dir];
                int ny = tmp.y + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(arr[nx][ny] >= 0){
                    arr[nx][ny] += currDust;
                    currCnt++;
                }
            }
            arr[tmp.x][tmp.y] -= (currDust *currCnt );
            if(arr[tmp.x][tmp.y] <= 0){
                arr[tmp.x][tmp.y] = 0;
            }
        }
    }
    static void rotate() {
        int[][] rotateDir = {{0,1,2,3} , {2,1,0,3}};
        // upper side rotate counter-clockwise
        for( int cleanNUM = 0 ; cleanNUM < 2 ; cleanNUM++ ){

            int nx = cleanear[cleanNUM].x , ny = cleanear[cleanNUM].y;

            for(int dir = 0 ; dir < 4 ; dir++ ){

                while(true){ // 다음꺼를 현재 위치로 옮겨야해
                    int tmpX = nx + dx[ rotateDir[cleanNUM][dir] ];
                    int tmpY = ny + dy[rotateDir[cleanNUM][dir]];

                    if(cleanNUM == 0){ // 위에꺼 범위 체크
                        if(tmpX < 0 || tmpX > cleanear[cleanNUM].x || tmpY < 0 || tmpY >= M ) break;
                    }else{ // 아래꺼 범위 체크
                        if(tmpX < 0 || tmpX >= N || tmpX < cleanear[cleanNUM].x || tmpY < 0 || tmpY >= M ) break;
                    }

                    if(  dir == 3 && arr[tmpX][tmpY] == -1 ) break; //마지막 방향에서 다음칸이 청정기면 종료
                    if( (dir == 0 && arr[nx][ny] == -1) || (dir == 2 && arr[nx][ny] == -1) ){
                        // 처음 시작점에서 현재칸이 청정기면 다음꺼만 0으로 만들어줘
                        arr[tmpX][tmpY] = 0;
                    }else{
                        arr[nx][ny] = arr[tmpX][tmpY];
                    }
                    nx = tmpX;
                    ny = tmpY;
                }
            }
            arr[cleanear[cleanNUM].x][cleanear[cleanNUM].y + 1] = 0;
        }
    }

    static class Node {
        int x, y, dust, spread;
        public Node(int x, int y, int spread) {
            this.x = x;
            this.y = y;
            this.spread = spread;
        }
    }

}
