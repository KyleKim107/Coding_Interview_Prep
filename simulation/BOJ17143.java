package simulation;

import java.util.*;
import java.io.*;

public class BOJ17143 {
    public static int[] dx = { 0, -1, 1, 0, 0 }, dy = { 0, 0, 0, 1, -1 };
    public static int[][] sharkTurn = {{},{2},{1},{4},{3}};
    public static int R,C,M,answer = 0;;
    public static Shark[][] arr;
    public static ArrayList< Shark>[][] arrr;
    public static int[][] MAP;

    public static Shark[] sharkList ;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("simulation/BOJ17143.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        R = Integer.parseInt(str.nextToken()); C = Integer.parseInt(str.nextToken()); M = Integer.parseInt(str.nextToken());
        if(M == 0){
            System.out.println(0);
            return;
        }
        arr = new Shark[R][C];
        MAP = new int[R][C];
        sharkList = new Shark[10000+1];
        int FisherCol = -1;
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(str.nextToken()) - 1, c = Integer.parseInt(str.nextToken()) -1 ,
                    s = Integer.parseInt(str.nextToken()), d = Integer.parseInt(str.nextToken()), z = Integer.parseInt(str.nextToken());
            Shark tmp = new Shark(r, c, s, d, z, 1);
            arr[r][c] = tmp;
            sharkList[z] = tmp;
            MAP[r][c] = z;
        }
        for(int i = 0 ; i < R ; i++ ){
            System.out.println(Arrays.toString(MAP[i]));
        }
        System.out.println();
        
        while (FisherCol++ < C-1) {

            System.out.println(FisherCol);
            hunt(FisherCol);
            // for(int i = 0 ; i < R ; i++ ){
            //     System.out.println(Arrays.toString(MAP[i]));
            // }
            // System.out.println();
            move(); // 상어 움직이기
            // 다시 정렬해주기
            for(int i = 0 ; i < R ; i++ ){
                System.out.println(Arrays.toString(MAP[i]));
            }
            System.out.println();

        }
        for(int i = 1 ; i < sharkList.length ; i++ ){
            if(sharkList[i] != null){
                Shark tmp =sharkList[i];
                System.out.println("tmp.x : " + tmp.x + "tmp.y : " + tmp.y + " tmp.live : " + tmp.live);
            }
        }
        System.out.println( answer);

    }
    public static void hunt(int FisherCol){
        for(int i = 0 ; i < R ; i++ ){
            if(arr[i][FisherCol] != null && arr[i][FisherCol].live == 1 ){
                System.out.println("arr[i][FisherCol].z : " + arr[i][FisherCol].z + " arr[i][FisherCol].x : " + arr[i][FisherCol].x + " arr[i][FisherCol].y : " + arr[i][FisherCol].y  );
                answer += arr[i][FisherCol].z;
                sharkList[ arr[i][FisherCol].z ].live = 0;
                arr[i][FisherCol] = null ;
                MAP[i][FisherCol] = 0;
                break;
            }

        }

    }
    
    
    public static void move(){
        arrr = new ArrayList[R][C];
        for(int i = 0 ; i < sharkList.length ; i++ ){
            if(sharkList[i] == null) continue;
            Shark curr = sharkList[i];
            if(curr.s == 0 || curr.live == 0) continue; // 죽거나 속도가0이면 패스
            arr[curr.x][curr.y] = null; // 움직이기전 제거
            MAP[curr.x][curr.y] = 0; // 움직이기전 제거
            int nx= curr.x , ny = curr.y, turn = curr.s;
            while(turn-- > 0){
                if(curr.z == 1){
                    System.out.println("nx : " + nx + " ny : " + ny + " dir : " + curr.d );
                }
                if(nx + dx[curr.d] < 0 || nx + dx[curr.d] >= R || ny + dy[curr.d] < 0  || ny + dy[curr.d] >= C){
                    curr.d = sharkTurn[curr.d][0];
                }
                nx +=  dx[curr.d];
                ny +=  dy[curr.d];
            }
            if(curr.z == 1){
                System.out.println("nx : " + nx + " ny : " + ny + " dir : " + curr.d );
            }
            curr.x = nx; curr.y = ny; // 현재 상어의 배치를 옮겨준다
            arrr[nx][ny].add(curr);//바로 하는게 아니고 나중에 한번에 해준다
        }
        rearrange();


    }
    public static void rearrange(){
        for(int i = 0 ; i < R ; i++ ){
            for(int j = 0 ; j < C ; j++ ){
                if(arrr[i][j].size() ==1 ){
                    Shark curr = arrr[i][j].get(0);
                    int x = curr.x , y = curr.y;
                    arr[x][y] = curr; // 현재상어가 자리로 이동한다
                    sharkList[curr.z] = curr;
                    MAP[x][y] = curr.z;
                }else{
                    int index = -1, maxWeight = Integer.MIN_VALUE;
                    for(int k = 0 ; k < arrr[i][j].size() ; k++ ){
                        if(arrr[i][j].get(k).z  > maxWeight){
                            maxWeight = arrr[i][j].get(k).z;
                            index = k;
                        }
                    }
                    Shark curr = arrr[i][j].get(index);
                    int x = curr.x , y = curr.y;
                    arr[x][y] = curr; // 현재상어가 자리로 이동한다
                    sharkList[curr.z] = curr;
                    MAP[x][y] = curr.z;
                    for(int k = 0 ; k < arrr[i][j].size() ; k++ ){
                        if(k != index){
                            sharkList[ arrr[i][j].get(index).z ].live = 0;
                        }
                    }
                }
            }
        }
    }
    // if(arr[nx][ny] != null ){ // 상어가 있을경우?
    //     if(  arr[nx][ny].z < curr.z){ // 들어온 상어가 클경우
    //         sharkList[ arr[nx][ny].z ].live = 0; // 배열에서 죽여준다
    //         arr[nx][ny] = curr; // 현재상어가 자리로 이동한다
    //         MAP[nx][ny] = curr.z;
    //     }else if(  arr[nx][ny].z > curr.z){// 이미 있던 상어가 클경우
    //         sharkList[curr.z].live = 0;
    //     }
    // }else{
    //     arr[nx][ny] = curr; // 현재상어가 자리로 이동한다
    //     sharkList[curr.z] = curr;
    //     MAP[nx][ny] = curr.z;

    // }
    
    static class Shark {
        int x, y, s, d, z, live;//  s는 속력, d는 이동 방향, z는 크기이다

        public Shark(int x, int y, int s, int d, int z, int live) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
            this.live = live;// 1: live 0: dead
        }
    }

}
