package HEAP.PriorityQueue;
import java.util.*;
import java.io.*;
public class BOJ17612ver2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("HEAP/PriorityQueue/BOJ17612.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<People> process = new PriorityQueue<People>(new Comparator<People>(){
            @Override
            public int compare(People a , People b){
                // 기다려야 할 시간이 같을 경우에는 가장 번호가 작은 계산대로 안내를 한다
                if(a.time == b.time){
                    return a.counter - b.counter;
                }
                return a.time - b.time;
            }
        });

        PriorityQueue<People> leaving = new PriorityQueue<People>(new Comparator<People>(){
            @Override
            public int compare(People a , People b){
                // 기다려야 할 시간이 같을 경우에는 가장 번호가 작은 계산대로 안내를 한다
                if(a.time == b.time){
                    return b.counter - a.counter;
                }
                return a.time - b.time;
            }
        });
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()) , K = Integer.parseInt(str.nextToken()) ;
        for(int i = 0 ; i < N ; i++ ){
            str = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(str.nextToken()) , num = Integer.parseInt(str.nextToken());

            if(process.size() < K){
                process.add(new People( id , process.size() + 1 , num));
                continue;
            }
            // for(People tmp : process){
            //     System.out.println("tmp.id : " + tmp.id + " tmp.counter : " + tmp.counter + " tmp.time : " + tmp.time );
            // }
            // System.out.println();
            People tmp = process.poll();
            leaving.add( tmp );
            process.add( new People(id , tmp.counter , tmp.time + num));
        }

        while(!process.isEmpty()){
            leaving.add(process.poll() );
        }
        int cnt = 1 , answer = 0;
        while(!leaving.isEmpty()){
            answer += cnt * leaving.poll().id;
            cnt ++;
        }

        System.out.println(answer);
    }

    static class People{
        int id, counter, time;
        public People(int id , int counter , int time){
            this.id = id;
            this.counter = counter;
            this.time = time;
        }

    }
}
