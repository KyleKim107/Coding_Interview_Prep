package Graph;
import java.util.*;
import java.io.*;
public class BOJ1194ver2 {
    public static int[] dx = { -1, 0, 1, 0 },dy = { 0, 1, 0, -1 };
    public static char[][] arr;
    public static boolean[][][] visit;
    public static int X,Y , answer = -1;

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Graph/BOJ1194.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), M = Integer.parseInt(str.nextToken());
        arr = new char[N][M];
        visit = new boolean[N][M][1 << 6];
        for(int i = 0 ; i < N ; i++ ){
            String tmp = br.readLine();
            for(int j = 0 ; j < M ; j++ ){
                arr[i][j] = tmp.charAt(j);
                if(arr[i][j] == '0'){
                    X = i; 
                    Y = j;
                }
            }
        }
        // Queue<Node>
    }
    static class Node{
        int x,y, flag ,count;
        public Node(int x, int y, int flag ,  int count){
            this.x =x;
            this.y =y;
            this.flag =flag;
            this.count =count;
        }
    }
    
}
