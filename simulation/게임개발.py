
import sys
from collections import deque


def turnLeft(nextD):
    if nextD -1 <0:
            nextD = 3
    else:
        nextD -= 1
    return nextD

dir = [(-1,0),(0,1),(1,0),(0,-1)]
n,m = map(int, sys.stdin.readline().split())
x,y,d = map(int, sys.stdin.readline().split())
a = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
b = []
res = 0
check = []
q = deque()
for line in a:
    tmp = line
    b=[]
    for ch in line:
        if ch == 1:
            b.append(-1)
        else:
            b.append(1)
    check.append(b)

q.append((x,y,d))
check[x][y] = 7
res += 1
while q:
    x,y,d = q.popleft()
    nextD = d 
    while True:
        nextD = turnLeft(nextD)
        dx,dy = dir[nextD]
        nextX, nextY =  dx + x , dy + y
        print((nextX,nextY))
        if check[nextX][nextY] == 1:
            print("------")
            break
        if nextD == d:
            nextD = turnLeft(nextD)
            break
        
    if check[nextX][nextY] == 1:
        q.append((nextX,nextY,nextD))
        check[x][y] = 7
        res += 1



print(res)
print(check)

