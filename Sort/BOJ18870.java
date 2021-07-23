package Sort;

import java.util.*;

public class BOJ18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int[] clone = arr.clone();
        Arrays.sort(clone);
        int idx=0;
        for (int i : clone) {
            if(!map.containsKey(i))
                map.put(i, idx++);
        }

        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
