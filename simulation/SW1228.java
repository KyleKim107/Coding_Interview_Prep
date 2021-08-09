package simulation;
import java.util.*;
import java.io.*;

public class SW1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int len = Integer.parseInt( br.readLine());
            int[] arr = new int[len];
            str = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < len ; i++){
                arr[i] = Integer.parseInt(str.nextToken());
            }
            int cmd = Integer.parseInt( br.readLine());
            str = new StringTokenizer(br.readLine());
            int[] newArr = arr; // 기본배열 복사
            int[] prevArr  ; // 다음턴에서 사용할 어레이
            for(int z = 0 ; z < cmd ; z++){
                str.nextToken();
                int index = Integer.parseInt(str.nextToken()) ;
                int numLen = Integer.parseInt(str.nextToken());
                int[] tmp = new int[numLen]; // 새로 입력받을 어래이
                int newLen = newArr.length +numLen; // 새로운 배열 길이
                prevArr = newArr; // 배열을 위해 킵
                newArr = new int[newLen]; // 새로운 배열 생성

                for(int i = 0 ; i < numLen ; i++ ){
                    tmp[i] = Integer.parseInt(str.nextToken());
                }


                for(int j = 0 ; j < index ; j++){ // 삽입 인덱스 전까지 초기화
                    newArr[j] = prevArr[j];
                }
                int tmpIndex = 0;
                for(int j = index ; j < index + numLen ; j++){ // 삽입값들 넣기
                    newArr[j] = tmp[tmpIndex++];
                }
                for(int j = index + numLen ; j < newLen ; j++){ // 기본 배열 나머지값 넣기
                    newArr[j] = prevArr[index++];
                }
            }
            System.out.printf("#%d " ,test_case );
            for(int p = 0 ; p < 10 ; p++){ //출력
                System.out.print(newArr[p] + " " );
            }
            System.out.println();
        }
    }
}
//449047 400905 139831 408347 512816 992679 693002 835918 768525 949227 