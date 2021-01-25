import sys
from collections import deque
dir = [(0,1),(1,0),(0,-1),(-1,0)]
N = int(sys.stdin.readline())
a =[[0]*(N) for _ in range(N)]
apple= int(sys.stdin.readline())
for _ in range(apple):
    i,j = map(int, sys.stdin.readline().split())
    a[i-1][j-1] = 1

def nextDir(p,j,di):
    
    if j == 'D':
        if di==4:
            di = 0
        else:
            di += 1
    elif j == 'L':
        if di == 0:
            di = 3
        else:
            di -= 1
    return di


com = int(sys.stdin.readline())
q = deque()
di = -1
q.append((0,0))
timer =0
flag = False
for p in range(com):
    if flag == True:
        break
    i,j = sys.stdin.readline().split()
    print((i,j))
    di = nextDir(p,j,di)
    for _ in range(int(i)):
        timer+= 1
        x,y = q[-1]
        direc= dir[di]
        print(direc)
        nx,ny = x+direc[0] , y+direc[1]
        
        if not(0 <=nx < N and 0 <= ny < N) or (nx,ny) in q:
            flag = True
            break
        if a[nx][ny] == 1:
            q.append((nx,ny))
            a[nx][ny] = 0
        elif a[nx][ny] == 1:
            q.append((nx,ny))
            t,b= q.popleft()
            print((t,b))

print(timer)

    

