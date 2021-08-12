package Permutation_And_Comb;
import java.util.*;

public class Combination {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            comb(arr, visited, 0, n, i);
        }

    }

        // 재귀 사용
        // 사용 예시 : comb(arr, visited, 0, n, r)
        static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
            if (r == 0) {
                print(arr, visited, n);
                return;
            }
            if (depth == n) {
                return;
            }

            visited[depth] = true; // visit에 표시해서 선택한다
            comb(arr, visited, depth + 1, n, r - 1); // depth가 하나씩 더해지면서 인덱스를 높인다
                                                // r로 선택하고 선택 안하고를 결정
            visited[depth] = false;
            comb(arr, visited, depth + 1, n, r);
        }

    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
