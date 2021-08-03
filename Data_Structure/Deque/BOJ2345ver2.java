package Data_Structure.Deque;


import java.util.*;

;public class BOJ2345ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		LinkedList<Ball> dq = new LinkedList<Ball>();
        int num = sc.nextInt();
        for(int i = 0 ; i < num ; i++){
            dq.add(new Ball(i + 1, sc.nextInt() ));
        }
        int val = 0 ;
        int currIndex = 0 ;
        for(int i = 0 ; i < num ; i++){
            if(val > 0){
                for(int j  = 0 ; j  < val-1 ; j++){
                    currIndex ++ ;
                    if(currIndex >= dq.size() ){
                        currIndex = 0;
                    }
                }

            }else if(val < 0 ){
                val *= -1;
                for(int j  = 0 ; j  < val; j++){
                    currIndex --;
                    if(currIndex < 0  ){
                        currIndex = dq.size()-1;
                    }
                }

            }
            Ball tmp = dq.get(currIndex);
            val = tmp.val;
            System.out.print(tmp.index + " ");
            dq.remove(currIndex);
            if(currIndex == dq.size())
                System.out.println("QQQQQQ");
                currIndex = 0;
        }
    }
}
class Ball{
    int index;
    int val;
    public Ball(int index , int val){
        this.index = index;
        this.val = val;
    }
}
