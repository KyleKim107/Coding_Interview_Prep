package Graph.BFS;

import java.io.*;
import java.util.*;

public class BOJ1260 {
    static int n,m,v;
	static int mp[][]=new int[1001][1001],check[] = new int[1001];
	
	static void dfs(int node)
	{
		System.out.print(node + " ");
		for(int i=1;i<=n;i++)
		{
			if(mp[node][i]==1&&check[i]==0)
			{
				check[i]=1;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		for(int i=1;i<=m;i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			mp[x][y]=mp[y][x]=1;
		}
		check[v]=1;
		dfs(v);
		System.out.println();
		check[v]=2;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		while(!q.isEmpty())
		{
			v = q.poll();
			System.out.print(v + " ");
			
			for(int i=1;i<=n;i++)
			{
				if(mp[v][i]==1&&check[i]!=2)
				{
					check[i]=2;
					q.offer(i);
				}
			}
		}
	}
}
