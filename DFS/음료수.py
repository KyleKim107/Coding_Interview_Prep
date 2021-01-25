import sys
from collections import deque
a=[]
dir = [(-1,0),(1,0),(0,1),(0,-1)]
vis = [[0]*5 for _ in range(4)]
for i in range(4):
    a.append(list(map(int, input())))

def bfs(i,j):
    q = deque()
    q.append((i,j))
    vis[i][j] = 1
    while q:
        x,y = q.popleft()
        for dx,dy in dir:
            nextX, nextY =  dx + x , dy + y
            if nextX<0 or nextX>=4 or nextY <0 or nextY >= 5:
                continue
            if a[nextX][nextY] == 0 and vis[nextX][nextY] == 0:
                q.append((nextX,nextY))
                vis[nextX][nextY] = 1

cnt = 0
for i in range(4):
    for j in range(5):
        if a[i][j] == 0 and vis[i][j] == 0:
            bfs(i,j)
            cnt +=1
print(vis)
print(cnt)





    