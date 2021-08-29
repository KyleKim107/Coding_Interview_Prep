package Brute_Force;
import java.util.*;
public class BOJ1987ver2 {
    static int R,C,ans,dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
	static char[][] map;

	static void dfs(int r,int c,int bit,int cnt){
        int a=1<<map[r][c]-'A';
		if((bit&a)>0)return;
		bit+=a;
		ans=Math.max(ans,++cnt);
		for(int[] d:dir){
			int nr=r+d[0],nc=c+d[1];
			if(nr>=0&&nc>=0&&nr<R&&nc<C)
			    dfs(nr,nc,bit,cnt);
		}
	}
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		R=s.nextInt();C=s.nextInt();map=new char[R][C];
		for(int i=0;i<R;i++)
			map[i]=s.next().toCharArray();
		dfs(0,0,0,0);
		System.out.print(ans);
	}
}
