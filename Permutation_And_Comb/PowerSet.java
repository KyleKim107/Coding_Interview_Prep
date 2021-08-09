package Permutation_And_Comb;

public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = 3;
        boolean[] visited = new boolean[n];

        powerSet(arr, visited, n, 0);
        // bit(arr, n);
    }

    static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
        if (idx == n) { // 끝까지 가면 종료
            print(arr, visited, n);
            return;
        }


        visited[idx] = true;
        powerSet(arr, visited, n, idx + 1);
        visited[idx] = false;
        powerSet(arr, visited, n, idx + 1);
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}
