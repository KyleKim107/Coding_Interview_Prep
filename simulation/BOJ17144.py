r,c,t = map(int,input().split())
matrix = [list(map(int,input().split())) for _ in range(r)]
dust = set([])
cleaner = []
for x in range(r):
    if matrix[x][0] == -1:
        cleaner.append(x)
d = [[-1,0],[1,0],[0,1],[0,-1]]

def spread( matrix , cleaner ):
    t_matrix = [[0]*c for _ in range(r)]
    for y in range(r):
        for x in range(c):
            if matrix[y][x] > 0:
                val = matrix[y][x] // 5
                if val == 0 : #나누기한 값이 0이면 그대로 놔눠
                    t_matrix[y][x] += matrix[y][x]
                    continue
                cnt = 0
                for dx, dy in d:
                    ax, ay = x+dx, y+dy
                    if ax == 0 and ay in cleaner:
                        continue
                    elif 0 <= ax < c and 0 <= ay < r:
                        cnt += 1
                        t_matrix[ay][ax] += val
                t_matrix[y][x] += matrix[y][x] - val*cnt

    return t_matrix

def clean(matrix,cleaner):
    cy1,cy2 = cleaner
    for y in range(cy1-1,0,-1):
        matrix[y][0] = matrix[y-1][0]
    for y in range(cy2+1,r-1):
        matrix[y][0] = matrix[y+1][0]


    matrix[0][0:c-1] = matrix[0][1:c]
    matrix[r-1][0:c-1] = matrix[r-1][1:c]
    
    for y in range(cy1):
        matrix[y][c-1] = matrix[y+1][c-1]
    for y in range(r-1,cy2,-1):
        matrix[y][c-1] = matrix[y-1][c-1]
    matrix[cy1][2:c] = matrix[cy1][1:c-1]
    matrix[cy2][2:c] = matrix[cy2][1:c-1]

    matrix[cy1][1] = 0
    matrix[cy2][1] = 0
    
for _ in range(t):
    for i in range(len(matrix)):
        print(matrix[i])
    print()
    matrix = spread(matrix,cleaner)

    for i in range(len(matrix)):
        print(matrix[i])

    clean(matrix,cleaner)

result = 0
for item in matrix:
    result += sum(item)
print(result)



# from collections import deque
# R,C,T = map(int, input().split())
# board = list( list( map(int, input().split())) for _ in range(R))
# dust, machine = deque() , []
# for i in range(R):
#     for j in range(C):
#         if board[i][j] != 0 and board[i][j] != -1:
#             dust.append((board[i][j],i,j))
#         if board[i][j] == -1:
#             machine.append([i,j])

# for _ in range(T):
#     L=len(dust)
#     for _ in range(L):
#         num ,x,y = dust.popleft()

#         numSpace, spreadSpace= 0,[], 
#         nextValue = num // 5
#         for dx,dy in [(1,0),(0,1),(-1,0),(0,-1)]:
#             if  0 <= dx+x < R and  0 <= dy+y < C:
#                 # if board[dx+x][dy+y] == 0:
#                 numSpace += 1
#                 board[dx+x][dy+y] =  num // 5
#                 dust.append((board[dx+x][dy+y] ,dx+x,dy+y ))
#         changeCurr = num - ((num//5)*numSpace)
#         board[x][y] = changeCurr
#     # for x in range(R):
#     #     for y in range(C):
#     #         if board[x][y] < 5 :
#     #             continue
#     #         spreadVal,numSpace = board[x][y] // 5, 0
#     #         for dx,dy in [(1,0),(0,1),(-1,0),(0,-1)]:
#     #             if  0 <= dx+x < R and  0 <= dy+y < C:
#     #                 numSpace += 1
#     #                 board[dx+x][dy+y] =  spreadVal
#     #                 # dust.append((board[dx+x][dy+y] ,dx+x,dy+y ))
#     #         board[x][y] -=  spreadVal*numSpace



#     print('move dust')
#     for i in range(R):
#         print(board[i])
#     print()

#     x,y = machine[0]

#     q = deque()
#     for i in range(x-1, 0, 1): # left
#         q.append(board[i][0])
#     for i in range(0,C): # top\
#         q.append(board[0][i])
#     for i in range(x ): # left
#         q.append(board[i][C-1])
#     for i in range(C-1, 0 , -1): # bottom
#         q.append(board[x][i])
#     print('before',q)
#     q.rotate(-1)
#     q.pop(), q.append(0)
#     print('after',q)
#     for i in range(x-1, 0, 1): # left
#         board[i][0] = q.popleft()
#     for i in range(0,C): # top\
#         board[0][i] = q.popleft()
#     for i in range(x ): # left
#         board[i][C-1] = q.popleft()
#     for i in range(C-1, 0 , -1): # bottom
#         board[x][i] = q.popleft()

#     q = deque()
#     x,y = machine[1]
#     for i in range(x+1 , R): # left
#         q.append(board[i][0])
#     for i in range(1 , C): # bottom
#         q.append(board[x][i])
#     for i in range(x-1 , 0, -1): #right
#         q.append(board[i][C-1])
#     for i in range(C-1 , 0, -1): 
#         q.append(board[x][i])
#     print('q',q)
#     q.pop(), q.append(0)
#     for i in range(x+1 , R): # left
#         board[i][0]= q.popleft()
#     for i in range(1 , C): # bottom
#         board[x][i] = q.popleft()
#     for i in range(x-1 , 0, -1): #right
#         board[i][C-1] = q.popleft()
#     for i in range(C-1 , 0, -1):
#         board[x][i] = q.popleft()
#     cnt = 2
#     for i in range(R):
#         cnt += sum(board[i])
#     print(cnt)
#     print('cleaning')
#     for i in range(R):
#         print(board[i])
#     print()
        
#     # T -= 1
#     # print('T', T)