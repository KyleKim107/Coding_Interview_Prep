package SWEA;
import java.util.*;

public class Test {
    public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		
		String order=s.next();

			// TODO Auto-generated method stub

			int index = 1;
			if(order.equals("1")) {
				for(int i = 1 ; i < 5 ; i++) {
					for(int j = 0 ; j < i ; j++) {
						System.out.printf("%d ", index++);
					}
					System.out.println();
				}
			}else {
				char st = 'A';
			
				for(int i = 1 ; i < 6 ; i++ ) {
					for(int j = 5 - i ; j > 0 ; j--) {
						System.out.printf("  ");
					}
					int pow = 2*i -1;
					for(int k = 0 ; k < pow ; k++) {
						System.out.printf("%s ",st);
						st += 1;
					}
					System.out.println();
				}
				
				
			}
		}
    
}
