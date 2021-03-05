import sys
from collections import deque

def bfs1():
    for i in range(n):
        for j in range(m):
            if a[i][j] == 'J':
                q.append((i,j,0))
                vis[i][j] = 1
                break
    while q:
            x , y, f= q.popleft()
            #print((x,y,f))
            if x -1 < 0 or x + 1 >= n or y -1 < 0 or y +1 >= m:
                if f:
                    continue
                print(vis[x][y])
                return 
            if x -1 >= 0 and a[x-1][y] == '.' and vis[x-1][y] == -1:
                vis[x-1][y] = vis[x][y] + 1
                q.append((x-1,y, f))
            if x + 1 < n and a[x+1][y] =='.'and vis[x+1][y] == -1:
                vis[x+1][y] = vis[x][y] + 1
                q.append((x+1,y, f))
            if y - 1 >= 0 and a[x][y-1] =='.' and vis[x][y-1] == -1:
                vis[x][y-1] = vis[x][y] + 1
                q.append((x,y -1, f))
            if y + 1 < m and a[x][y+1] =='.' and vis[x][y+1] == -1:
                vis[x][y+1] = vis[x][y] + 1
                q.append((x,y+1, f))
            #print(vis)
    print("IMPOSSIBLE")
    
n, m = map( int , sys.stdin.readline().split() )
a = [ list(map(str , input() )) for _ in range(n) ]
vis = [[-1]*m for _ in range(n)]
# print(vis)
q = deque()
for i in range(n):
    for j in range(m):
        if a[i][j] == 'F':
            q.append((i,j,1))
            vis[i][j] = 1
bfs1()

