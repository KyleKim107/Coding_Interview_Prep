from sys import stdin
from collections import deque
input = stdin.readline

r, c = map(int, input().split())
m = [list(input().strip()) for _ in range(r)]
dist = [[0]*c for _ in range(r)]
q = deque()
for i in range(r):
    for j in range(c):
        if m[i][j] == 'J':
            sx, sy = i, j # J 저장하기
        elif m[i][j] == 'F':
            q.append((i, j, 1)) # 불 인덱스 저장 1?
            dist[i][j] = 1  


def bfs():
    q.append((sx, sy, 0)) # 거리 0 
    dist[sx][sy] = 1 # J 거리 1 
    while q: # 큐에 J,F 동시에 넣어준다
        x, y, f = q.popleft()
        print((x,y,f))
        for dx, dy in (-1, 0), (0, 1), (1, 0), (0, -1):
            nx, ny = x+dx, y+dy
            if nx < 0 or nx >= r or ny < 0 or ny >= c: # 탈출 했을때
                if f:# 불은 그냥 보내 J 는 종료
                    continue
                print(dist[x][y]) # 넘어 가기 전에 현재 dis를 출력
                return
            if not dist[nx][ny] and m[nx][ny] != '#':
                #print(dist)
                q.append((nx, ny, f))
                dist[nx][ny] = dist[x][y]+1

    print("IMPOSSIBLE")

bfs()

