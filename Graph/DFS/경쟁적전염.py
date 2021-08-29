import sys
from collections import deque

N,K = map(int,sys.stdin.readline().split())
a = [ list(map(int, sys.stdin.readline().split())) for _ in range(N) ]
S,X,Y= map(int,sys.stdin.readline().split())
vis = [[0]*N for _ in range(N)]
data = []


for i in range(N):
    for j in range(N):
        if a[i][j] != 0:
            data.append((a[i][j],0 ,i,j))
data.sort()
q = deque(data)
while q:
    val, time , x, y = q.popleft()
    if time > S:
        break
    for dx,dy in [(1,0),(-1,0),(0,1),(0,-1)]:
        nx , ny = dx +x , dy + y
        if nx < 0 or nx >= N or ny < 0 or ny>= N:
            continue
        if  a[nx][ny] == 0:
            q.append(( a[nx][ny],time+1 ,nx,ny))
            a[nx][ny] = val


print(a[X-1][Y-1])            


            
            





