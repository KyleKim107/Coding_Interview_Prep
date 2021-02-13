import sys
from collections import deque
dir = [(0,1),(1,0),(0,-1),(-1,0)]
N = int(sys.stdin.readline())
a =[[0]*(N) for _ in range(N)]
apple= int(sys.stdin.readline())
for _ in range(apple):
    i,j = map(int, sys.stdin.readline().split())
    a[i-1][j-1] = 1

def nextDir(j,di):
    
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


command = int(input())
comL = []
for comm in range(command):
    tic , way = sys.stdin.readline().split()
    comL.append((int(tic),way))
# print( comL)
# print( len(comL))
timer = 0
q = deque()
q.append((0,0)) 
a[0][0] =2
index = 0
direction = 0
flag = False
tic = comL[0][0]
way = comL[0][1]
while True:
    
    timer += 1
    x,y = q[-1]
    nx,ny = x + dir[direction][0] , y + dir[direction][1]
    if not(0<= nx < N and 0 <= ny < N) or a[nx][ny] == 2 or (nx,ny) in q:
        break
    else:
        if a[nx][ny] == 1:
            q.append((nx,ny))
            a[nx][ny] =2
            #print(("append", (nx,ny)))
        else:
            q.append((nx,ny))
            a[nx][ny] =2
            i,j = q.popleft()
            a[i][j] = 0
    # for i  in range(len(a)):
    #     print(a[i], end = '\n')
    # print( ("time", timer))
    if timer == tic :
        direction = nextDir(way,direction)
        #print(index)
        if index < command-1:
            index += 1
            tic, way = comL[index]


print(timer)









    



    

