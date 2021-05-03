import sys
N = int(input())
mine,currMap= [],[]
mineList = []
for i in range(N):
    line = list(map(str,sys.stdin.readline().rstrip() ))
    mine.append(line)
    for j in range(len(line)):
        if line[j] == '*':
            mineList.append((i,j))

for i in range(N):
    line = list(map(str,sys.stdin.readline().rstrip()))
    currMap.append(line)
# print(mine)
# print(currMap)

answer =[['.']*N for _ in range(N)]
# print(currMap)
flag = False
for i in range(N):
    for j in range(N):
        kill = 0
        if currMap[i][j] == 'x':
            if mine[i][j] =='*':
                flag = True
            if i - 1 >= 0 :
                if mine[i-1][j] =='*': # 위
                    kill += 1
            if i + 1 < N : 
                if mine[i+1][j] == '*': # down
                    kill += 1
            if j - 1 >= 0 :
                if mine[i][j-1] =='*': # 왼
                    kill += 1
            if j + 1 < N : 
                if mine[i][j+1] =='*': # 오른
                    kill += 1

            if i - 1 >= 0 and j - 1 >= 0 :
                if mine[i-1][j-1] =='*': #왼위
                    kill += 1
            if i + 1 < N and j + 1 < N  : 
                if mine[i+1][j+1] =='*': # 오른아래
                    kill += 1
            if i + 1 < N and j - 1 >= 0: 
                if mine[i+1][j-1] =='*': # 왼아래
                    kill += 1
            if i -1  >= 0 and j + 1 < N: 
                if mine[i-1][j+1] =='*': # 오른위
                    kill += 1
            answer[i][j] = str(kill)

if flag == True:
    for x,y in mineList:
        answer[x][y] = '*'
      

for i in range(N):
    print(''.join(answer[i]))
# 8
# ...**..*
# ......*.
# ....*...
# ........
# ........
# .....*..
# ...**.*.
# .....*..
# xxxx....
# xxxx....
# xxxx....
# xxxxx...
# xxxxx...
# xxxxx...
# xxx.....
# xxxxx...
