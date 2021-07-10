import sys
input = sys.stdin.readline

n = int(input())
orders = []
favorite = dict()
for _ in range(n**2):
    lst = list(map(int,input().split()))
    favorite[lst[0]] = lst[1:]
    orders.append(lst[0])
board = [[0 for col in range(n)] for row in range(n)]
direction = [(0,-1) , (0,1) , (1,0) , (-1,0)]

def range_check(x,y):
    return 0<=x<n and 0<=y<n

for order in orders:
    pick = (-1,-1,-401,-401)    # 친구가 있는 공간, 빈공간, 행번호, 열번호
    for i in range(n):
        for j in range(n):
            if board[i][j] != 0: continue
            favorite_space , empty_space = 0, 0
            for dx, dy in direction :
                nx ,ny = i+dx, j+dy
                if not range_check(nx,ny) : continue
                if board[nx][ny] in favorite[order]: favorite_space+=1
                if board[nx][ny] == 0: empty_space +=1
            new_pick = (favorite_space, empty_space, -i, -j) # 가장 좋은곳 우선/ 엠티 스페이스 우선 / 로우 우선 / 컬럼 우선
            print(new_pick)
            pick = max(pick, new_pick)
    board[-pick[2]][-pick[3]] = order
ret = 0
for i in range(n):
    for j in range(n):
        favorite_space = 0
        for dx,dy in direction:
            nx, ny = i+dx, j+dy
            if not range_check(nx,ny): continue
            if board[nx][ny] in favorite[board[i][j]]: favorite_space+=1
        if favorite_space ==0: continue
        ret += 10**(favorite_space-1)
        print(10**(favorite_space-1))
print(ret)

