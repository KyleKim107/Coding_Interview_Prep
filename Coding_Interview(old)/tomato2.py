import sys
from collections import deque

def bfs(a, haveTo):
    cnt = 0
    while True:
        size =len(haveTo)
        if size == 0:
            break
        cnt += 1
        for _ in range(size): # 모두다 펼펴
            z,x,y = haveTo.popleft()
            if x - 1 >= 0 and a[z][x-1][y] == 0:  #up
                a[z][x-1][y] =1
                haveTo.append((z,x-1,y))
            if x + 1 < n and a[z][x+1][y] == 0: # down
                a[z][x+1][y] =1
                haveTo.append((z,x+1,y))
            if y - 1 >= 0 and a[z][x][y-1] == 0: # down
                a[z][x][y-1] =1
                haveTo.append((z,x,y-1))
            if y + 1 < m and a[z][x][y+1] == 0: # down
                a[z][x][y+1] =1
                haveTo.append((z,x,y+1))
            if z -1 >= 0 and a[z-1][x][y] == 0: # Upstair
                a[z-1][x][y] = 1
                haveTo.append((z-1,x,y))
            if z +1 < h and a[z+1][x][y] == 0: # downStair
                a[z+1][x][y] = 1
                haveTo.append((z+1,x,y))
    return cnt

def solve(a):
    haveTo = deque()
    for i in range(h):
        for j in range(n):
            for k in range(m):
                if a[i][j][k] == 1:
                    haveTo.append((i,j,k))
    res = bfs(a, haveTo)
    for i in range(h):
        for j in range(n):
            for k in range(m):
                if a[i][j][k] == 0:
                    print(-1)
                    return 0
    print(res-1)
                
m,n, h = map(int, sys.stdin.readline().split())   
a = [[list( map(int, sys.stdin.readline().split())) for _ in range(n)]for i in range(h)] 
          
solve(a)
              





        

