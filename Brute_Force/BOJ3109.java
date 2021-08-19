package Brute_Force;

import java.util.*;
import java.io.*;

public class BOJ3109 {
  public static int cnt = 0, N, M;
  public static char[][] arr;
  public static int[][] visit;
  public static int[] dx = { -1, 0, 1 };
  public static int[] dy = { 1, 1, 1 };

  public static boolean func(int x, int y) {
    if (y == M - 1) {
      for (int i = 0; i < N; i++) {
        System.out.println(Arrays.toString(visit[i]));
      }
      System.out.println();
      cnt += 1;
      return true;
    }
    for (int dir = 0; dir < 3; dir++) {
      int nx = x + dx[dir];
      int ny = y + dy[dir];
      if (0 <= nx && nx < N && 0 <= ny && ny < M && visit[nx][ny] == 0 && arr[nx][ny] == '.') {
        visit[nx][ny] = 1;
        if (func(nx, ny)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("Brute_Force/BOJ3109.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());
    N = Integer.parseInt(str.nextToken());
    M = Integer.parseInt(str.nextToken());
    arr = new char[N][M];
    visit = new int[N][M];
    for (int i = 0; i < N; i++) {
      String tmp = br.readLine();
      arr[i] = tmp.toCharArray();
    }
    for (int i = 0; i < N; i++) {
      visit[i][0] = 1;
      func(i, 0);
    }
    for (int i = 0; i < N; i++) {
      System.out.println(Arrays.toString(visit[i]));
    }
    System.out.println();
    System.out.println(cnt);
  }
}
