package Graph;

import java.util.*;
import java.io.*;

public class BOJ17471 {
    public static int N, minV = Integer.MAX_VALUE, cnt = 0;
    public static int[] people , redF;
    public static int[][] flags;
    public static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/BOJ17471.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(str.nextToken());
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) { // from a
            str = new StringTokenizer(br.readLine());
            int adj = Integer.parseInt(str.nextToken());
            for (int j = 0; j < adj; j++) { // to b
                int b = Integer.parseInt(str.nextToken()) - 1;
                list[i].add(b);
            }
        }
        
        func(0,new int[N]);
        if(cnt > 0) System.out.println(minV);
        else System.out.println(-1);
    }

    public static void func(int curr, int[] check) {
        if (curr == N) {
            int red = 0,blue = 0;
            if(possible(check)){
                cnt++;
                for(int i = 0 ; i < N ; i++ ){
                    if(flags[1][i] == 1) red += people[i];
                    else if(flags[2][i] == 2) blue += people[i];
                }
                minV = Math.min(minV, Math.abs(red - blue));
            }
            return;
        }
        check[curr] = 0;
        func(curr + 1, check);
        check[curr] = 1;
        func(curr + 1, check );
    }

    public static boolean possible(int[] check ){
        ArrayList<Integer> red = new ArrayList<>(), blue = new ArrayList<>();
        for(int i = 0 ; i < N ; i++ ){ // 조합으로 나눠진걸 red와 blue에 나눠담아
            if(check[i] == 0) red.add(i);
            else blue.add(i);
        }
        if(red.size() == 0 || blue.size() == 0) return false;//둘중 하나라도 비워져 있으면 그만
        
        flags = new int[3][];
        flags[1]= new int[N]; // red
        flags[2]= new int[N]; // blue

        dfs(red.get(0) , 1, red ); // 모두다 이어져 있어야 하니 처음꺼만 불러주면 다해줘
        for(int i = 0 ; i < red.size() ; i++ ){ // 다 돌았나 체크 파워셋에 지정된거랑 각 노드랑 연결된게 다르다면 돌 수 없어
            if(flags[1][red.get(i)] != 1)  return false;
        }
        dfs(blue.get(0) , 2, blue );
        for(int i = 0 ; i < blue.size() ; i++ ){ // 다 돌았나 체크
            if(flags[2][blue.get(i)] != 2)  return false;
        }
        return true;
    }

    public static void dfs(int start, int color, ArrayList<Integer> team){
        flags[color][start] = color; // 함수를 부를때와 dfs내에서 부를때 다 포함되어 있는걸 체크하기에 그냥 색칠
        for(int i = 0 ; i < team.size() ; i++ ){
            int next = team.get(i);
            if(flags[color][next] == 0 && list[start].contains(next)){ //배정받은 팀에도 있고, 아직 색칠되지 않고 노드도 연결되어 있다면
                dfs( next ,  color,  team);
            }
        }
    }
}
