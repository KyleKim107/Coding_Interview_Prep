import sys
from collections import deque

n, m, r = map(int, sys.stdin.readline().rstrip().split())
arr = [list(map(int,sys.stdin.readline().rstrip().split())) for _ in range(n)]
# 4 4 2
# 1 2 3 4
# 5 6 7 8
# 9 10 11 12
# 13 14 15 16

def rotate(x,y,height, width):
    q = deque()
    for i in range(x, x+width): # 위
        q.append(arr[y][i])

    for i in range(y+1, y+height): # 오른쪽
        q.append(arr[i][x+width-1])
    print(q)
    for i in range(x+width-2, x, -1): #밑 1 + 2 -2  =1
        q.append(arr[y+height-1][i]) 
    print(q)
    for i in range(y+height-1, y, -1): # 왼
        q.append(arr[i][x])
    print(q)
    q.rotate(-r)
    for i in range(x, x+width):
        arr[y][i] = q.popleft()
    
    for i in range(y+1, y+height):
        arr[i][x+width-1] = q.popleft()
    
    for i in range(x+width-2, x, -1):
        arr[y+height-1][i] = q.popleft()
    
    for i in range(y+height-1, y, -1):
        arr[i][x] = q.popleft()


x,y = 0, 0
height, width = n,m
while True:
    if height == 0 or width == 0:
        break
    rotate(x,y,height, width)
    x += 1
    y += 1
    height -= 2
    width -= 2


for i in range(n):
    for j in range(m):
        print(arr[i][j], end = ' ')
    print()