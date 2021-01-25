import sys
dir = [(-1,0),(0,1),(1,0),(0,-1)] # 북 동 남 서
n,m = map(int,sys.stdin.readline().split())
x,y,d = map(int,sys.stdin.readline().split())
a = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
vis = [[0]*m for _ in range(n)]
turn = 0
ans = 1
def changeDIR(direction):
    direction -= 1
    if direction == -1:
        direction = 3
    return d
tim = 20
vis[x][y] = 1
while True :
    tim -= 1
    d = changeDIR(d)
    dx,dy = dir[d]
    nx,ny = dx +x , dy + y
    if vis[nx][ny] == 0 and a[nx][ny] == 0 :
        vis[nx][ny] = 1
        x , y, d  = nx ,ny, d
        turn = 0
        ans += 1
        continue
    else:
        turn += 1

    if turn == 4 :
        if a[x - dx][y- dy] != 1 :
            x, y = x - dx , y - dy
            turn = 0
        else:
            break
     

print(ans)

        




    



    
