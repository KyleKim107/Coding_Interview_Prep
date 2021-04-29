from collections import deque
from sys import stdin
dir = [ (0,1), (1,0), (0,-1), (-1,0) ]
def getDIR(currD, nexD):
    if nexD == 'D':
        if currD + 1 >= 4:
            return 0
        else:
            return currD +1 
    else:
        if currD - 1 < 0:
            return 3
        else:
            return currD -1 
N = int(stdin.readline())
App = int(stdin.readline())
a = list([0]*N for _ in range(N))
for _ in range(App):
    b,c = map( int, stdin.readline().split() )
    a[b-1][c-1] = 2
order = int(stdin.readline())
orderList = []
for _ in range(order):
    b,c = stdin.readline().split()
    orderList.append(( int(b), c ) )
snake  = deque()
snake.append((0,0))

time = 0
nextTime , nexDirec= orderList.pop(0)
numO = 1
currD = 0
while True:
    if time == nextTime:
        currD=getDIR(currD,nexDirec)
        numO += 1
        if numO <= order:
            nextTime, nexDirec = orderList.pop(0)

    x,y = snake[0]
    nx, ny = x + dir[currD][0] , y+dir[currD][1]
    if 0 <= nx < N and 0 <= ny < N and a[nx][ny] != 3:
        if a[nx][ny] == 2:
            snake.appendleft((nx,ny))
            a[nx][ny] =3
        else:
            snake.appendleft((nx,ny))
            a[nx][ny] =3
            n,m =snake.pop()
            a[n][m]= 0
    else:
        time += 1    
        break
    time += 1
print(time)
    