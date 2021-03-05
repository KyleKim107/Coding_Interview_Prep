import sys
from collections import deque

input = sys.stdin.readline
n,m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]
check = [[False]*m for _ in range(n)]
cnt, area = 0 ,0

def bfs(i,j):
    q = deque()
    check[i][j] = True
    q.append((i,j))
    space = 1
    while q:
        x, y = q.popleft()
        for dx,dy in (-1,0),(1,0),(0,-1),(0,1):
            nx, ny = x + dx, y + dy
            if nx >= n or  ny >= m or nx < 0 or ny < 0:
                continue
            if not check[nx][ny] and a[nx][ny]:
                q.append((nx,ny))
                check[nx][ny] = True
                space += 1
    return space

for i in range(n):
    for j in range(m):
        if a[i][j] and not check[i][j]:
            area = max(area , bfs(i,j))
            cnt += 1

print(cnt)
print(area)
        


