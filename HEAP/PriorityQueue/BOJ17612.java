package HEAP.PriorityQueue;
import java.util.*;
import java.io.*;
public class BOJ17612 {  static int n, k;
    public static void main(String[] args) throws IOException{
        System.setIn( new FileInputStream("HEAP/PriorityQueue/BOJ17612.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        PriorityQueue<line> wait_pq = new PriorityQueue<>(new Comparator<line>() {
            @Override
            public int compare(line l1, line l2) {
                if(l1.time == l2.time) { // 시간이 같다면
                    return l1.counter - l2.counter; // 카운터가 낮은 순서대로
                }
                return l1.time - l2.time; // 시간이 적게 걸리는 순서대로
            }
        });
        PriorityQueue<line> leave_pq = new PriorityQueue<>(new Comparator<line>() {
            @Override
            public int compare(line l1, line l2) {
                if(l1.time == l2.time) { // 시간이 같다면
                    return l2.counter - l1.counter; // 높은 순서대로
                }
                return l1.time - l2.time; // 다 똑같다면 시간이 빠른 순서대로
            }
        });

        long ans = 0;
        long cnt = 1;
        for(int i = 0 ; i < n ; i++) { // 핵심은 계속 넣어주며 시간을 갱신 하는거다
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(wait_pq.size() < k) { // 다 채울때 까지 컨티뉴
                wait_pq.add(new line(people, wait_pq.size() + 1, w));
                continue;
            }

            line end = wait_pq.poll(); // 계산 다 끝난 사람
            // System.out.println(end.counter);
            leave_pq.add(end);
            wait_pq.add(new line(people, end.counter, end.time + w)); // 동시에 새로운 사람을 넣어준다
        }

        while (!wait_pq.isEmpty()) {
            leave_pq.add(wait_pq.poll()); // 계산 다 끝난 사람 이제 모두 빼주기
        }

        while (!leave_pq.isEmpty()) {
            ans += cnt++ * leave_pq.poll().people;
        }
        System.out.println(ans);
    }
    static class line {
        int people, counter, time;
        line(int people, int counter, int time) {
            this.people = people;
            this.counter = counter;
            this.time = time;
        }
    }
}
