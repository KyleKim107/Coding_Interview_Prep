import sys
N,M,K = map(int, sys.stdin.readline().split())
stickers = []
board = [[0]*M for _ in range(N)]

for _ in range(K):
    R, C = map(int,sys.stdin.readline().split())
    tmp = list(list( map(int, sys.stdin.readline().split())) for _ in range(R))
    stickers.append(tmp)

def rotate(arr):
    n,m = len(arr), len(arr[0])    # n = 2 m = 4
    dummy = list(list([0]*n) for _ in range(m))
    for i in range(m):
        for j in range(n):
            dummy[i][ n - 1 - j] = arr[j][i]
    return dummy

def check(board , line , x ,y):
    for i in range(len(line)):
        for j in range(len(line[0])):
            if line[i][j] == 0: 
                continue
            elif line[i][j] == 1 and board[x + i][y + j] == 0:
                continue
            else:
                return False
    return True

def attach(line , x,y ):
    for i in range(len(line)):
        for j in range(len(line[0])):
            if  line[i][j] != 0 :
                board[ x + i ][ y + j ] = line[i][j]

for line in stickers:
    for _ in range(4):
        flag = True
        for i in range(N):
            for j in range(M):
                if i + len(line)-1 < N and j + len(line[0])-1 < M  and  check(board , line ,i ,j):
                    attach(line , i,j)
                    flag = False
                    break
                else:
                    continue
            if not flag:
                break

        if flag:
            line = rotate(line)
        else:
            break
            
cnt = 0
for line in board:
    cnt += sum(line)
print(cnt)


