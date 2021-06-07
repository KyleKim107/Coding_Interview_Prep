from sys import stdin
from copy import deepcopy
dir = [ (-1,0), (-1,-1),(0,-1),(1,-1),(1,0),(1,1),(0,1),(-1,1) ]

read = stdin.readline
a=[[],[],[],[]]
fishes = [[0,0,0]]

for i in range(4):
    temp = list(map(int, read().split()))
    for j in range(0,4):
        a[i].append([temp[j*2],temp[j*2+1]-1])
        fishes.append([temp[j*2],i,j])
fishes.sort()

def findFish(b, fishes ,x, y,Shark_DIR):
    l = []
    for _ in range(4):
        x,y = x + dir[Shark_DIR][0], y + dir[Shark_DIR][1]
        if 0 <= x < 4 and 0 <= y < 4 and fishes[  b[x][y][0]  ][0] != -1:
            # print('x,', x , 'y', y, b[x][y][0] )
            l.append([b[x][y][0]  ,x ,y])
    return l

def movefish(b,sx,sy):
    for i in range(1,17):
        if fishes[i][0] != -1:
            F, x, y =fishes[i]
            currD = b[x][y][1]
            # print(x,y,currD)
            for _ in range(8):
                nx,ny = x + dir[currD][0], y + dir[currD][1]
                if 0 <= nx < 4 and 0 <= ny < 4 and (nx,ny) != (sx,sy):
                    # print('i', i,'currD',currD, 'nx,', nx , 'ny', ny )
                    nextF , nextF_DIR= b[nx][ny]
                    b[x][y],b[nx][ny] = [nextF , nextF_DIR] , [F, currD]
                    fishes[F],fishes[nextF] = [F , nx, ny], [nextF , x, y]
                    break
                currD = (currD + 1) % 8
                
    return b


def solve():
    b = deepcopy(a)
    dfs(a,fishes, 0 , 0,0)

def dfs(b,fishes,cnt, sx, sy):
    global maxV
    b = deepcopy(b)
    currFish =a[sx][sy][0]
    a[sx][sy][0] = 0
    fishes[currFish][0] = -1

    b = movefish( b, sx,sy)
    # print(b)
    Shark , x, y = fishes[0]
    Shark , Shark_DIR  =a[x][y]
    l = findFish(b, fishes ,x, y, Shark_DIR)
    

    maxV= max(maxV , cnt+currFish)

    for F, x, y in l:

        dfs(b,fishes,cnt + F, x, y)

    
        

maxV = -1e9
solve()
print(maxV)

