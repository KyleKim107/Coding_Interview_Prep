from sys import stdin
from collections import deque
dir =[(1,0),(-1,0),(0,1),(0,-1)]
read = stdin.readline
n, m = map(int, read().split())
a = list( list( map( int , read().split() )) for _ in range( n))
visited = list( [-1] * m for _ in range(n))
gx,gy =0,0
zero = []
for i in range(n):
    if 2 in a[i]:
        for j in range(len(a[i])):
            if 2 == a[i][j]:
                gx, gy = i,j
    if 0 in a[i]:
        for j in range(len(a[i])):
            if  0 == a[i][j]:
                zero.append((i,j))
    
q = deque([(gx,gy)])
visited[gx][gy] = 0
while q :
    x,y =q.popleft()
    for i in range(4):
        nx,ny = x + dir[i][0], y + dir[i][1]
        if 0 <= nx < n and 0 <= ny < m and a[nx][ny] != 0 and visited[nx][ny]== -1:
            q.append((nx,ny))
            visited[nx][ny]= visited[x][y] + 1

for a, b in zero:
    visited[a][b] = 0
for line in visited:
    st = ''
    for i in range(len(line)):
        if i == 0:
            st += str(line[i])
        else:
            st += ' '+str(line[i])
    print(st)
    
            
    

                