from collections import deque
from sys import stdin
dx = [1, -1, 0 ,0]
dy = [0, 0, -1 ,1]
N,M = map(int, stdin.readline().split())
a = list( list( map( int, stdin.readline().split() ) ) for _ in range(N) )
q = []
for i in range(N):
    for j in range(M):
        if a[i][j] != 0 :
            q.append( ( a[i][j] , i , j ) ) # value , x, y
time = 0
flag = False
while True:
    time += 1
    length = len(q)
    memo = []
    for i in range(length):
        value ,x , y = q.pop(0)
        DIRcnt = 0
        for i in range(4):
            nx , ny  = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if a[nx][ny] == 0:
                    DIRcnt += 1
        if value - DIRcnt > 0:
            q.append((value - DIRcnt , x, y))
            a[x][y] = value - DIRcnt
        else:
            a[x][y] = -1
            memo.append((x,y))
    for b,c in memo:
        a[b][c] = 0
    # print(('length after',len(q)))
    blockCNT = 0
    if not q:
        flag = True
        break
    # print(a)
    visited = list( [0]* M for _ in range(N))
    for i in range(N):
        for j in range(M):
            if a[i][j] != 0 and visited[i][j] == 0:
                # print(('a[i][j]','visited[i][j]',a[i][j],visited[i][j]))
                # print((i,j))
                blockCNT += 1
                Q = []
                Q.append((i,j))
                visited[i][j] = 1
                while Q:
                    x, y = Q.pop(0)
                    for z in range(4):
                        nx,ny = x + dx[z], y + dy[z]
                        if 0 <= nx < N and 0 <= ny < M:
                            if a[nx][ny] != 0 and visited[nx][ny] == 0:
                                Q.append((nx,ny))
                                visited[nx][ny] = 1
    # print(time, end = '\n')
    # for i in range(len(a)):
    #     print(a[i])
    if blockCNT >= 2:
        # print(('blockCNT',blockCNT))
        # for i in range(len(visited)):
        #     print(visited[i])
        break
if flag:
    print(0) 
else:
    print(time)          
    
