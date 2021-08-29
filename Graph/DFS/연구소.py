import sys
from itertools import combinations
from collections import deque
n,m = map(int, sys.stdin.readline().split())
a = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
vis = [[0]*m for _ in range(n)]
wall = []
gem = []
for i in range(n):
    for j in range(m):
        if a[i][j] ==0: 
            wall.append((i,j))
        elif a[i][j] == 2:
            gem.append((i,j))

wall = list(combinations(wall ,3))

def setWall(walls):
    x1,y1 = walls[0]
    x2,y2 = walls[1]
    x3,y3 = walls[2]
    a[x1][y1] = 1
    a[x2][y2] = 1
    a[x3][y3] = 1
def releaseWall(walls):
    x1,y1 = walls[0]
    x2,y2 = walls[1]
    x3,y3 = walls[2]
    a[x1][y1] = 0
    a[x2][y2] = 0
    a[x3][y3] = 0

def gemSp():
    for x1,y1 in gem:
        q = deque()
        q.append((x1,y1))
        vis[x1][y1] = 2
        while q:
            x,y = q.popleft()
            for dx,dy in [(1,0),(-1,0),(0,1),(0,-1)]:
                nx,ny = dx+x, dy+y
                if nx >= n or nx <0 or ny < 0 or ny >= m:
                    continue
                if a[nx][ny] == 0 and vis[nx][ny] == 0:
                    q.append((nx,ny))
                    vis[nx][ny] = 2   


def bfs():
    total =0
    for i in range(n):
        for j in range(m):
            q = deque()
            counter = 0
            if a[i][j] == 0 and vis[i][j] == 0:
                q.append((i,j))
                vis[i][j] = 1
                counter += 1
                while q:
                    x,y = q.popleft()
                    for dx,dy in [(1,0),(-1,0),(0,1),(0,-1)]:
                        nx,ny = dx+x, dy+y
                        if nx >= n or nx < 0 or ny < 0 or ny >= m:
                            continue
                        if a[nx][ny] == 0 and vis[nx][ny] == 0:
                            q.append((nx,ny))
                            vis[nx][ny] = 1
                            counter += 1
            total += counter
    return total
                        


cnt = -1
for three in wall:
    setWall(three)
    gemSp()
    cnt = max(cnt ,bfs())
    releaseWall(three)
    vis = [[0]*m for _ in range(n)]

print(cnt)
