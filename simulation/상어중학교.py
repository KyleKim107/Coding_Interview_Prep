import sys
from collections import deque
dx = [0,1,0,-1]
dy = [1,0,-1,0,] # 우 , 밑, 위, 좌

N,M = map( int,sys.stdin.readline().split() )
a = list(list( map(int, sys.stdin.readline().split())) for _ in range(N))
visit = list([0]*N for _ in range(N))
for i in range(N):
    for j in range(N):
        color = -99
        Q = deque()
        if a[i][j] != -1:
            color = a[i][j]
            visit[i]][j] = 1
            Q.append((i,j,a[i][j]))
            while Q:
                i,j,v = Q.popleft()
                for i in range(4):
                    nx,ny = 


        # visit = list([0]*N for _ in range(N))







# 5 3
# 2 2 -1 3 1
# 3 3 2 0 -1
# 0 0 0 1 2
# -1 3 1 3 2
# 0 3 2 2 1