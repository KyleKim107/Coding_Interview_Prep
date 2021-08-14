package Brute_Force;
import java.util.*;
import java.io.*;

public class BOJ15686ver2 {
    static int N, M;
	static int[][] map;
	static List<Pos> chicken;
	static List<Pos> select;
	static List<Pos> house;
	
	static int answer = Integer.MAX_VALUE;
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    // 종대님 코드
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		chicken = new ArrayList<>();
		select = new ArrayList<>();
		house = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chicken.add(new Pos(i, j));
				}
				if(map[i][j] == 1) {
					house.add(new Pos(i, j));
				}
			}
		}
		
		for(int i = 1; i <= M; i++) {
			combination(0, 0, i);
		}
		
		System.out.println(answer);
		
	}
	
	public static void combination(int start, int count, int m) {
		if(count == m) {
			calculate();
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			select.add(chicken.get(i));
			combination(i+1, count+1, m);
			select.remove(select.size() - 1);
		}
	}
	
	public static void calculate() {
		int cityChkDist = 0;
		for(int i = 0; i < house.size(); i++) {
			Pos h = house.get(i);
			int chkDist = Integer.MAX_VALUE;
			
			for(int j = 0; j < select.size(); j++) {
				Pos c = select.get(j);
				int dist = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
				
				chkDist = Math.min(chkDist, dist);
				if(chkDist == 1)
					break;
			}
			
			cityChkDist += chkDist;
		}
		
		answer = Math.min(answer, cityChkDist);
	}
    
}
