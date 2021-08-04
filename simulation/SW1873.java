package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW1873 {
    static char[][] map;
	static int H, W;	// 맵의 넓이와 높이
	static int cx, cy, cDir;  // 탱크의 위치와 방향
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static String data = "1\n" + 
			"3 7\n" + 
			"***....\n" + 
			"*-..#**\n" + 
			"#<.****\n" + 
			"23\n" + 
			"SURSSSSUSLSRSSSURRDSRDS";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(data);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][];
			// 입력데이터
			for (int h = 0; h < H; h++) {				
				map[h] = sc.next().toCharArray();
			}
			
			getTankPosition();		
			sc.nextInt();
			char[] commands = sc.next().toCharArray();
			for (char command : commands) {
				switch (command) {
				case 'S': shoot(); break;
				default: directionChangeAndMove(command); break;
				}
			}
			
			System.out.print("#" + t + " ");
			Arrays.stream(map).forEach(System.out :: println);
		}
	}
	
	static void getTankPosition() {
		for (int x = 0; x < H; x++) {
			for (int y = 0; y < W; y++) {
				int dir = "^v<>".indexOf(map[x][y]);
				if (dir != -1) {
					cx = x;
					cy = y;
					cDir = dir;
				}
			}
		}
	}
	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < H && y < W;
	}
	static void goMove(int x, int y) {
		// 이동하려는 위치가 이동이 가능한지 체크
		if (isIn(x, y) && map[x][y] == '.') {
			map[cx][cy] = '.';
			cx = x;
			cy = y;
		}
	}
	static void shoot() {
		int nx = cx + dx[cDir];
		int ny = cy + dy[cDir];
		while (true) {
			if (isIn(nx, ny) == false) break;
			
			switch(map[nx][ny]) {
			case '.': case '-': break;
			case '*': map[nx][ny] = '.'; return;
			case '#': return;
			}
			nx += dx[cDir];
			ny += dy[cDir];
		}
	}
	static void directionChangeAndMove(char command) {
		// 방향은 무조건 바뀐다.
		cDir = "UDLR".indexOf(command);
		
		// 설정된 방향으로 이동하기
		goMove(cx + dx[cDir], cy + dy[cDir]);
		
		// 전차의 현재의 위치의 방향을 변경한다.
		map[cx][cy] = "^v<>".charAt(cDir);
	}
}
