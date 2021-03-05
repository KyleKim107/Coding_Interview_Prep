import sys
sys.setrecursionlimit(100000)

N,M = map(int,input().split())
Map = [list(map(int,input()))for i in range(N)]
visited = [[0 for _ in range(M)] for _ in range(N)]
dx,dy = [-1,1,0,0],[0,0,-1,1]

def bfs():
    cnt = 1
    q = [(0,0,cnt)]
    visited[0][0] = 1

    while q:
        x = q[0][0]
        y = q[0][1]
        cnt = q[0][2]
        del q[0]
        
        if x==N-1 and y==M-1:
            print(cnt)
        
        for w in range(4):
            xx,yy = x+dx[w],y+dy[w]
            if xx<0 or xx>=N or yy<0 or yy>=M or visited[xx][yy]==1 or Map[xx][yy]==0:
                continue
            q.append((xx,yy,cnt+1))
            visited[xx][yy] = 1    
print(Map)
bfs()

