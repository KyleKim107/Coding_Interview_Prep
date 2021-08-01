from sys import stdin

def func():
    global row, col , stone
    for i in range(19):
        for j in range(19):
            if a[i][j] != 0:
                result = [0]*8
                for d in range(8):
                    nx = i + dir[d][0]
                    ny = j + dir[d][1]
                    cnt = 0
                    while 0 <= nx< 19 and 0 <= ny < 19 and a[nx][ny] == a[i][j]:
                        cnt += 1
                        nx +=  dir[d][0]
                        ny +=  dir[d][1]
                    result[d] = cnt
                for k in range(4):
                    if (result[k] + result[k+4]) == 4:
                        if col > j and row > i:
                            row = i
                            col = j
                            stone = a[i][j]
                            flag = True
                            return



a = list(list( map(int, stdin.readline().split())) for _ in range(19))
dir = [(0,-1),(-1,0),(1,1),(-1,1),(0,1),(1,0),(-1,-1),(1,-1)]
row, col, stone = 20,20, 0
flag = False
func();
print(stone)
print( row+1,col+1 )





