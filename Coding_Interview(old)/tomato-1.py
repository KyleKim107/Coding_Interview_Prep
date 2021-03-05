import sys
from collections import deque

def bfs():
    cnt = 0
    # print("enter")
    while True:
        size =len(haveTo)
        if size == 0:
            break
        cnt += 1
        for _ in range(size): # 모두다 펼펴
            x,y = haveTo.popleft()
            if x - 1 >= 0 and a[x-1][y] == 0:  #up
                a[x-1][y] =1
                haveTo.append((x-1,y))
            if x + 1 < n and a[x+1][y] == 0: # down
                a[x+1][y] =1
                haveTo.append((x+1,y))
            if y - 1 >= 0 and a[x][y-1] == 0: # down
                a[x][y-1] =1
                haveTo.append((x,y-1))
            if y + 1 < m and a[x][y+1] == 0: # down
                a[x][y+1] =1
                haveTo.append((x,y+1))
    return cnt


m,n = map(int, sys.stdin.readline().split())
a = [list( map(int, sys.stdin.readline().split())) for _ in range(n)]
haveTo = deque()

for i in range(n):
    for j in range(m):
        if a[i][j] == 1:
            # print((i,j))
            haveTo.append((i,j))

res= bfs()
# print(a)
for i in range(len(a)):
    if 0 in a[i]:
        print(-1)
        break
    if i == n-1:
        print(res-1)


        




        

