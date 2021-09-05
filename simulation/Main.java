package simulation;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[6];
        int maxR = 0;
        int maxC = 0;
        for (int i = 0; i < 6; i++) {
            int com = sc.nextInt();
            arr[i] = sc.nextInt();
            if (com == 1 || com == 2)
                maxC = Math.max(maxC, arr[i]);
            else if (com == 3 || com == 4)
                maxR = Math.max(maxR, arr[i]);
        }
        int sum = arr[0] * arr[5];

        for (int i = 0; i < 5; i++) {
            sum += arr[i] * arr[i + 1];
        }
        System.out.println((maxC * maxR - (3 * maxC * maxR - sum)) * n);
    }
}
