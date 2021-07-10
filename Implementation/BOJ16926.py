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
    for i in range(x, x+width): # 위 룹들은 갯수만 맞쳐주는거고, 안에 있는것들은
        q.append(arr[x][i])

    for i in range(y+1, y+height): # 오른쪽
        q.append(arr[i][x+width-1])
    # print(q)
    for i in range(x+width-2, x, -1): #밑 1 + 2 -2  =1
        q.append(arr[y+height-1][i])
    # print(q)
    for i in range(y+height-1, y, -1): # 왼
        q.append(arr[i][y])
    # print(q)
    q.rotate(-r)
    for i in range(x, x+width):
        arr[x][i] = q.popleft()

    for i in range(y+1, y+height):
        arr[i][x+width-1] = q.popleft()
    
    for i in range(x+width-2, x, -1):
        arr[y+height-1][i] = q.popleft()
    
    for i in range(y+height-1, y, -1):
        arr[i][y] = q.popleft()


x,y = 0, 0
height, width = n,m
while True:
    if height == 0 or width == 0:
        break
    rotate(x,y,height, width)
    x += 1 # 안으로 들어갈 수록 한칸씩 떙겨서 쓰게됨
    y += 1
    height -= 2 # 
    width -= 2


for i in range(n):
    for j in range(m):
        print(arr[i][j], end = ' ')
    print()