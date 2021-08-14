package simulation;
import java.util.*;
import java.io.*;
class Pair{
    int x,y;
    public Pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}
public class BOJ3197 {
    public static int[] dx = {1,-1, 0,0};
    public static int[] dy = {0,0,1,-1};
    public static int N , M;
    public static char[][] arr;
    // public static int[][] visit;
    public static void melt(){
        ArrayList<Pair> al = new ArrayList<>();
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                if (arr[i][j] == 'X'){
                    for( int dir = 0 ; dir < 4 ; dir++){
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if ( 0<= nx && nx < N & 0<= ny && ny < M   && arr[nx][ny]== '.') {
                            al.add( new Pair(i,j));
                            break;
                        }
                    }
                    }
                }
            }
            Iterator i = al.iterator();
            while(i.hasNext()){
                Pair tmp = (Pair) i.next();
                arr[tmp.x][tmp.y] = '.';
            }
        }

    public static boolean check(){
        int[][] visit = new int[arr.length][arr[0].length];
       for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                if (arr[i][j] != 'L') continue;
                Queue<Pair> Q = new LinkedList<>();
                Q.add(new Pair(i,j));
                visit[i][j] = 1;
                while(Q.size() >0){
                    Pair pair = Q.remove();
                    for(int dir = 0 ; dir < 4 ; dir++ ){
                        int nx = pair.x + dx[dir];
                        int ny = pair.y + dy[dir];
                        if ( 0<= nx && nx < N & 0<= ny && ny < M   && arr[nx][ny] != 'X') {
                            if (visit[nx][ny] == 0){
                                if(arr[nx][ny] == 'L'){
                                    return true;
                                }
                                Q.add(new Pair(nx,ny));
                                visit[nx][ny] = 1;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("simulation/BOJ3197.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken()) ;
        arr = new char[N][M];
        for(int i = 0 ; i < N ; i++){
            String tmp = br.readLine();
                arr[i] = tmp.toCharArray();
        }
        int day = 0;
        while(true){
            if (check()){
                break;
            }
            melt();
            day++;
        }
        System.out.println(day);
        
    }
    
}
