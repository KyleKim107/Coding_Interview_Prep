N,M = map(int, input().split())
DIR = [(-1,0),(0,1),(-1,0),(0,-1)]
# dx = [-1,-,-1,0]
# dy = [0,1,0,-1]
x,y,dir = map(int, input().split())
a = list(list(map(int,input().split())) for _ in range(N) )
cnt = 0
def checkLeft(currD):
    if currD == 0:
        return 3
    else:
        return currD - 1

finding = 0
while True:
    if a[x][y] == 0:#1
        cnt += 1
        a[x][y] =2
        finding = 0
    else: #2
        dir = checkLeft(dir)
        LX,LY = DIR[dir]
        if a[x - LX][y- LY] == 0 : #왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
            x -= LX
            y -= LY
            cnt += 1 
            continue
        else:
            finding += 1
            if finding == 4: #네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
                BX,BY = DIR[dir]
                x -= BX 
                y -= BY
                if a[x][y] == 1:
                    break
for i in range(len(a)):
    print(a[i])
print(cnt)



        
