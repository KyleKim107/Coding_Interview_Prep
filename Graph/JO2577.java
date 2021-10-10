package Graph;

import java.util.*;
import java.io.*;

public class JO2577 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Graph/JO2577.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()), d = Integer.parseInt(str.nextToken()),
                k = Integer.parseInt(str.nextToken()), c = Integer.parseInt(str.nextToken());
        System.out.println(" k : " + k + " c : " + c);
        Integer[] stores = new Integer[d + 1];
        for (int i = 1; i <= d; i++) {
            stores[i] = (Integer) i;
        }
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = stores[Integer.parseInt(br.readLine())];
        }
        System.out.println(Arrays.toString(arr));
        int maxV = Integer.MIN_VALUE, leng = 1;
        while (leng++ < N) {
            System.out.println("leng : " + leng);
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                int start = i, turn = leng;

                while (turn-- > 0) {
                    if (!list.contains(arr[start]))
                        list.add(arr[start++]);
                    else
                        break;
                    start = start >= N ? 0 : start;
                }
                if (list.size() == leng) {
                    if (list.size() >= k) {
                        if (!list.contains(stores[c]))
                            list.add(stores[c]);
                    }
                    System.out.print(list + " ");
                    System.out.println();

                    maxV = Math.max(maxV, list.size());
                }

            }
        }

        System.out.println(maxV);

    }

}
