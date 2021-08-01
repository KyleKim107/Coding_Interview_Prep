from sys import stdin

# a = list(list( map( int , stdin.readline().split()) for _ in range(19)))
a = list( [0]*20 for _ in range(20))
n = int(stdin.readline())

def countRow(x,y, stone):
    cnt = 0
    for i in range(5): # 가로
        if 0 < x < 20 and 0 < y+i < 20 and a[x][y+i] == stone:
            cnt += 1
        else:
            break
    if cnt == 5:
        if 0 < x < 20 and 0 < y-1 < 20 :
            if a[x][y-1] == stone:
                return False
        if 0 < x < 20 and 0 < y+5 < 20 :
            if a[x][y+5] == stone:
                return False
    return cnt == 5

def countCol(x,y, stone):
    cnt = 0
    for i in range(5): # 가로
        if 0 < x+i < 20 and 0 < y < 20 and a[x+i][y] == stone:
            cnt += 1
        else:
            break
    if cnt == 5:
        if 0 < x-1 < 20 and 0 < y < 20 :
            if a[x-1][y] == stone:
                return False
        if 0 < x+5 < 20 and 0 < y < 20 :
            if a[x+5][y] == stone:
                return False
    return cnt == 5

def countVer(x,y, stone):
    cnt = 0
    for i in range(5): # 가로
        if 0 < x+i < 20 and 0 < y+i < 20 and a[x+i][y+i] == stone:
            cnt += 1
        else:
            break
    if cnt == 5:
        if 0 < x-1 < 20 and 0 < y-1 < 20 :
            if a[x-1][y-1] == stone:
                return False
        if 0 < x+5 < 20 and 0 < y+5 < 20 :
            if a[x+5][y+5] == stone:
                return False
    return cnt == 5


        

flag = False
answer = 30
for i in range(n):
    x, y = map(int, stdin.readline().split())
    if i % 2 == 0:
        a[x][y] = 1
    else:
        a[x][y] = 2
  
    if i >= 9:
        for j in range(1,20):
            for k in range(1,20):
                if a[j][k] != 0:
                    if countCol(j,k, a[j][k]) or countCol(j,k, a[j][k]) or countVer(j,k, a[j][k]):
                        flag = True
                        answer= i
                        break
    if flag :
        break
for _ in range(n -(answer +1)):
    x, y = map(int, stdin.readline().split())


print(answer+1)
# for i in range(n):
#     print(a[i])    
