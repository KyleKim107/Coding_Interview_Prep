package Brute_Force;

import java.util.*;


import java.io.*;

public class SW5644 {
    // public static int[][][] elemap;
    public static int[] dx = { 0, -1, 0, 1, 0 };
    public static int[] dy = { 0, 0, 1, 0, -1 };
    public static int numCharger ,totalA,totalB;
    public static Charger[] chargers;
    public static int[] Arange, Brange, powerArr;
    public static double[] bestPower;

    public static void getBestChoice(int aX  , int aY  , int bX , int bY ){
        Arange = new int[numCharger];
        Brange = new int[numCharger];
        bestPower = new double[numCharger];
        for( int c = 0 ; c < numCharger ; c++ ){
            Charger elec = chargers[c];
            if(manhattan(aX, aY, elec.x , elec.y, elec.type)){
                Arange[c] = 1;
            }
            if(manhattan(bX, bY, elec.x , elec.y, elec.type)){
                Brange[c] = 1;
            }
        }
        for(int cnt = 0 ; cnt < numCharger ; cnt ++){
            double div = Arange[cnt]+ Brange[cnt];
            if(div > 0){
                bestPower[cnt] = chargers[cnt].power / div;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Brute_Force/SW5644.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        int Test = Integer.parseInt(br.readLine());
        for (int test = 1; test <= Test; test++) {
            totalA = 0 ;
            totalB = 0 ;
            int[][] arr = new int[10][10];
            str = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(str.nextToken());
            numCharger = Integer.parseInt(str.nextToken());
            int[] A = new int[M+1];
            int[] B = new int[M+1];
            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                A[i] = Integer.parseInt(str.nextToken());
            }
            // System.out.println(Arrays.toString(A));
            
            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(str.nextToken());
            }
            // System.out.println(Arrays.toString(B));
            chargers = new Charger[numCharger];
            for (int i = 0; i < numCharger; i++) { // 충전소 배열하기
                str = new StringTokenizer(br.readLine());
                chargers[i] = new Charger(Integer.parseInt(str.nextToken()) - 1, Integer.parseInt(str.nextToken()) - 1, Integer.parseInt(str.nextToken()) , Integer.parseInt(str.nextToken()));
                // bfs(i, chargers[i].y ,chargers[i].x ,chargers[i].type, chargers[i].power );
            }
            int aX = 0 , aY = 0 , bX = 9, bY = 9;
            for(int index = 0 ; index < M+1 ; index++){
                // System.out.println("Index : " + index);
                getBestChoice(aX  , aY  ,  bX , bY );
                // System.out.println(Arrays.toString(Arange));
                // System.out.println(Arrays.toString(Brange));
                // System.out.println(Arrays.toString(bestPower));
                double Amax = Integer.MIN_VALUE, Aindex = -1.0;
                double Bmax = Integer.MIN_VALUE, Bindex = -1.0;
                for(int c = 0 ; c < numCharger ; c++){
                    if (Arange[c] == 1 ){
                        if(Amax <bestPower[c] ){
                            Amax = bestPower[c];
                            Aindex = c;
                        }
                    }
                    if (Brange[c] == 1 ){
                        if(Bmax <bestPower[c] ){
                            Bmax = bestPower[c];
                            Bindex = c;
                        }
                    }
                }
                if(Aindex == Bindex){ // 나눠 먹기
                    totalA += (Aindex != -1 ? bestPower[(int)Aindex] : 0);
                    totalB += (Bindex != -1 ? bestPower[(int)Bindex] : 0);;
                }else{// 다먹기
                    totalA += (Aindex != -1 ? chargers[ (int)Aindex].power : 0);
                    totalB += (Bindex != -1 ? chargers[ (int)Bindex].power : 0);
                }

                // System.out.println("totalA :" + totalA);
                // System.out.println("totalB :" + totalB);
                // System.out.println(" aX " + aX + " aY " + aY + " bX :" + bX + " bY :" + bY );
                // System.out.println();
                // 현재 위치에서 충전 해당칸에 몇개 있는지 알기
                //uses charger[]

                //나가기
                if(index == M +1){ break;}
                
                //이동
                aX += dx[A[index]];
                aY += dy[A[index]];
                bX += dx[B[index]];
                bY += dy[B[index]];
            }
            System.out.println("Answer :" + (totalA + totalB));
        }
    }
    public static boolean manhattan(int x , int y , int charX , int charY , int range){
        int n = Math.abs(x - charX) + Math.abs( y - charY);
        return (  n <= range  ?  true : false );
    }

    // public static class Node {
    //     int x, y;

    //     public Node(int x, int y) {
    //         this.x = x;
    //         this.y = y;
    //     }
    // }
    public static class Charger {
        int x, y , type, power;

        public Charger(int y  ,int x, int type , int power) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.power = power;
        }
    }

}
// 4 4 1 100
// 7 10 3 40
// 6 3 2 70

 // public static void bfs(int turn, int y, int x, int type, int power) {
    //     Queue<Node> Q = new LinkedList<>();
    //     Q.offer(new Node(x, y));
    //     elemap[turn][x][y] = power;
    //     while (type-- > 0) {
    //         int len = Q.size();
    //         for (int a = 0; a < len; a++) {
    //             Node node = Q.remove();
    //             for (int dir = 1; dir < 5; dir++) {
    //                 int nx = node.x + dx[dir];
    //                 int ny = node.y + dy[dir];
    //                 if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) {
    //                     continue;
    //                 }
    //                 elemap[turn][nx][ny] = power;
    //                 Q.offer(new Node(nx, ny));
    //             }
    //         }
    //     }
    //     for (int i = 0; i < 10; i++) {
    //         System.out.println(Arrays.toString(elemap[turn][i]));
    //     }
    //     System.out.println();

    // }