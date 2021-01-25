import sys
from itertools import combinations
from collections import deque
N = int(sys.stdin.readline())
t, walls ,a,tmp=[],[],[],[]


for i in range(N):
    tmp = sys.stdin.readline().split()
    for j in range(len(tmp)):
        if tmp[j] == 'T':
            t.append((i,j))
        if tmp[j] == 'X':
            walls.append((i,j))
    a.append(tmp)


def lookU(x,y):
    for i in range(1,N):
        if x-i < 0 or y < 0 or a[x-i][y] == 'O':
            return True
        elif a[x-i][y] == 'S':
            return False
    return True

def lookD(x,y):
    for i in range(1,N):
        if x+i >= N or a[x+i][y] == 'O':
            return True
        elif a[x+i][y] == 'S':
            return False
    return True

def lookL(x,y):
    for i in range(1,N):
        if y-i < 0  or a[x][y-i] == 'O':
            return True
        elif a[x][y-i] == 'S':
            return False
    return True
def lookR(x,y):
    for i in range(1,N):
        if y+i >= N  or a[x][y+i] == 'O':
            return True
        elif a[x][y+i] == 'S':
            return False
    return True

def bfs():
    global t
    q = deque()
    cnt = 0

    for x,y in t:
        if  lookU(x,y) and  lookD(x,y) and  lookL(x,y) and lookR(x,y):
            cnt +=1
    
    # print(cnt)    
    if cnt == len(t):
        return True
    else:
        return False
        
        
# walls = list(combinations(walls,3))
flag = False

for wall in combinations(walls,3):
    for x, y in wall:
        a[x][y] = 'O'
    # if wall[0] == (0,3) and wall[1] == (1,1) and wall[2] == (2,2):
    #     print(a)
    flag = bfs()
    if flag == True:
        flag = True
        break
    for x, y in wall:
        a[x][y] = 'X'


if flag == True:
    print("YES")
else:
    print("NO")



    



