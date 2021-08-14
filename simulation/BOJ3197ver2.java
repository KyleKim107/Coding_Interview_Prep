package simulation;
import java.util.*;
import java.io.*;

public class BOJ3197ver2 {

	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static Queue<Node> q;
	static Queue<Node> waterQ;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] map;
	static boolean[][] visited;
	static Node[] swan;
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("simulation/BOJ3197.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // row size
		C = Integer.parseInt(st.nextToken()); // column size
		
		q = new LinkedList<>();
		waterQ = new LinkedList<>();
		swan = new Node[2];
		map = new char[R][C]; // 백조는 두개다
		visited = new boolean[R][C];
		
		// 데이터 입력
		int swanIdx = 0;
		for(int r = 0 ; r < R ; ++r) {
			char[] line = br.readLine().toCharArray();
			for(int c = 0 ; c < C ; ++c) {
				map[r][c] = line[c];
				if(map[r][c] == 'L') {
					swan[swanIdx++] = new Node(r, c);
				}
				if(map[r][c] != 'X') {//"." and "L" // 모든 물과 백조를 큐에 넣는다
					waterQ.offer(new Node(r, c));
				}
			}
		}
		
		// 출발점이 되는 백조 
		q.offer(swan[0]);
		visited[swan[0].r][swan[0].c] = true;
		
		int day = 0;
		boolean meet = false;
		
		while(true) {
			Queue<Node> nextQ = new LinkedList<>();

			while(!q.isEmpty()) { //
				Node now = q.poll();
				
				// 백조를 만날시 종료
				if(now.r == swan[1].r && now.c == swan[1].c) {
					meet = true;
					break;
				}
				
				for(int d = 0 ; d < 4 ; ++d) {
					int nr = now.r + dir[d][0];
					int nc = now.c + dir[d][1];
					
					if(nr >= R || nr < 0 || nc >= C || nc < 0 || visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					
					// 물에 인접한 얼음으로 다음 날 백조가 탐색할 지역 
					if(map[nr][nc] == 'X') { // 물에 인접한 얼음들
						nextQ.offer(new Node(nr, nc));
						continue;
					}
					// 현재 탐색 가능 지역, 얼음을 피해서 두번째 백조를 찾아 떠난다.
					q.offer(new Node(nr, nc));
				}
			} // end of while(q) 얼음을 제외한 모든 노드들을 탐색한 후 룹에서 나온다.
			
			// 백조가 만났으면 종료 
			if(meet) break;
			// q를 다음날 탐색할 지역이 담긴 nextQ로 바꾼다. // 얼음들의 위치가 들어가 있다
			q = nextQ; // 위에 룹에서 다시 돌림
			
			// 얼음을 녹인다.
			int size = waterQ.size();
			
			for(int i = 0 ; i < size ; ++i) { // 사이즈를 정하고 돌리면 딱 현재 가지고 있는것들만 비울 수 있다!!
				Node now = waterQ.poll();
				
				for(int d = 0 ; d < 4 ; ++d) {
					int nr = now.r + dir[d][0];
					int nc = now.c + dir[d][1];
					
					if(nr >= R || nr < 0 || nc >= C || nc < 0) continue;
					
					// 물에 인접한 얼음을 발견하면 녹이고 다시 큐에 넣는다.딱 물에 붙어있는 한겹만 녹인다
					if(map[nr][nc] == 'X') {
						map[nr][nc] = '.';
						waterQ.offer(new Node(nr, nc));// 현재 지워진 얼음칸들의 배열을 저장한다
					}
				}
			}
			day++;
		}
		
		System.out.println(day);
	}
    
}
