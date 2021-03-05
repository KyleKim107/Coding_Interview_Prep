import sys
from collections import deque

def bfs():
    flag = True
    if a[1][1] == 2:
        flag = False
    else:
        q = deque()
        q.append((1,1))
    a[1][1] = 9
    if flag:
        while q:
            x,y= q.popleft()
            
            if a[x][y] == 2 :
                a[x][y] = 9
                break
            if a[x][y+1] == 1 and a[x+1][y] == 1:
                a[x][y] =9
                break
            if a[x][y+1] == 1: # 오른쪽으로 이동시 벽이면 밑으로
                nx, ny = x+1 , y
            elif a[x][y+1] != 1:
                nx, ny = x , y+1
            
            q.append((nx,ny))
            a[x][y] = 9

    for line in a:
        for i in range(10):
            if i == 9:
                print(line[i] )    
            else:
                print(line[i] , end=" ")
        

a = [list(map(int, sys.stdin.readline().split())) for _ in range(10)]
bfs()

