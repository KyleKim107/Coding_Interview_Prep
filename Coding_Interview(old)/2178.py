import sys
from collections import deque
input = sys.stdin.readline


n, m = map(int, sys.stdin.readline().split())
# a = [list(map(int,input()))for i in range(n)]
a = [input()[:m] for _ in range(n)]

check = [[-1]*m for _ in range(n)]

def bfs(i,j):
    q = deque()
    check[i][j] = 1
    q.append((i,j))
    while q:
        x,y = q.popleft()
        for dx, dy in (-1,0),(1,0),(0,1),(0,-1):
            nx, ny = x + dx , y+ dy
            if nx >= n or ny >= m or nx < 0 or ny < 0:
                continue
            if check[nx][ny] == -1 and a[nx][ny] == 1 :
                q.append((nx,ny))
                check[nx][ny] = check[x][y] +1
print(a)
bfs(0,0)
print(check[n-1][m-1])
