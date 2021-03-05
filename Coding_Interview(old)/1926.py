from sys import stdin
from collections import deque
input = stdin.readline

n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]
check = [[False]*m for _ in range(n)]
cnt, area = 0, 0

def bfs(i, j):
    q = deque()
    q.append((i, j))
    ret = 1 # 적도어 하나는 있을거 아냐
    check[i][j] = True
    while q:
        x, y = q.popleft()# queue
        for dx, dy in (-1,0), (1,0), (0,-1), (0,1):
            nx, ny = x+dx, y+dy # 방향 설정하기
            if nx < 0 or nx >= n or ny < 0 or ny >= m: # 범위 안에 있는지 확인하기
                continue # pass
            if not check[nx][ny] and a[nx][ny]: # 
                q.append((nx, ny))
                check[nx][ny] = True
                ret += 1 # area 갯수
    return ret

# print(a)
for i in range(n): # 매칸 확인하러가
    for j in range(m):
        if not check[i][j] and a[i][j]: # a[][] 가 1인걸 확인해
            area = max(area, bfs(i, j)) # 가장큰 area를 찾아
            cnt += 1 #지역 개수 
print(cnt)
print(area)