package simulation;
/**
3  
7    
0 0 1 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 1 0 1 0 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0
9  
0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0 0
0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0 1
11 
0 0 1 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 1
0 0 0 1 0 0 0 0 1 0 0
0 1 0 1 1 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
 */


import java.util.ArrayList;
import java.util.Scanner;

public class SW_1767ver2 {

	static int N, maxCoreCnt, minWireLen, totalCoreCnt; // 판크기, 최대코어수, 최소전선길이, 처리할코어수
	static int[][] map;  // 멕시노스판
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<int[]> list;  // 코어를 담을 리스트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			maxCoreCnt = 0;
			minWireLen = Integer.MAX_VALUE;

			N = sc.nextInt();
			map = new int[N][N];
			list = new ArrayList<int[]>(); // 처리해야할 가자리가 아닌 코어들을 저장할 리스트
			// 입력받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1 || map[i][j] == 0)
						continue; // 가장자리에 위치한 코어는 이미 연결한 것으로 간주한다.

					list.add(new int[] { i, j });
				}
			}
			totalCoreCnt = list.size();
			solve(0, 0, 0);	// 처리할 리스트의 인덱스, 선택이 가능한 코어수, 연결된 전선의 길이
			System.out.println("#" + t + " " + minWireLen);
		}
		sc.close();
	}

	private static void solve(int index, int coreCnt, int wireLen) {
		// 남아있는 코어의 수가 현재 최대 연결된 코어의 수보다 작다면 더이상 진행할 필요 없음
		if (coreCnt  + totalCoreCnt - index < maxCoreCnt) return;
		
		if (index == totalCoreCnt) {
			if (maxCoreCnt < coreCnt) {
				maxCoreCnt = coreCnt;
				minWireLen = wireLen;
			} else if (maxCoreCnt == coreCnt) { // 최대 코어갯수가 같다면 최소길이의 전선으로...
				minWireLen = Math.min(minWireLen, wireLen);
			}
			return;
		}

		// 코어 선택 전선 놓아보기(4방향)
		int[] pos = list.get(index);
		int x = pos[0];
		int y = pos[1];
		for (int d = 0; d < 4; d++) {
			if (possible(x, y, d)) {  // 해당방향으로 가장자리까지 닿을 수 있다면 전원연결 가능
				solve(index + 1, coreCnt + 1, wireLen + setStatus(x, y, d, 2)); // 전선을 놓고 다음 코어로 넘어감
				setStatus(x, y, d, 0);   // 놓았던 전선 지우기(되돌리기)
			}
		}
		
		// 코어 비선택
		solve(index + 1, coreCnt, wireLen);
	}

	// 현코어의 위치에서 해당 방향으로 전선을 놓는게 가능한지 체
	private static boolean possible(int x, int y, int dir) {
		int nx = x, ny = y;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) return true;
			if (map[nx][ny] >= 1) return false; // 전선을 놓으려는 위치에 다른 코어나 전선이 이미 있다면 전선 놓는 것은 불가능
		}
	}

	// 해당 방향으로 전선을 놓거나 해제하기(status - 2(전선놓기), 0(전선빼기))
	private static int setStatus(int x, int y, int dir, int status) {
		int cnt = 0;
		int nx = x, ny = y;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) return cnt;
			
			map[nx][ny] = status;
			cnt++;
		}
	}
}