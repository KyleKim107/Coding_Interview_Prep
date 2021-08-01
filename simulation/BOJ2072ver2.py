N = int(input())
matrix = [[0] * 21 for _ in range(21)]
di = [0, 1, 1, 1, 0, -1, -1, -1]
dj = [1, 1, 0, -1, -1, -1, 0, 1]
turn = [1,2]
for i in range(N):
    x, y = map(int, input().split())
    stone = turn[i % 2]
    matrix[x][y] = stone #하나를 놓을때마다 그거에 대한 조사를 해줘
    result = [0] * 8
    for k in range(8):
        cnt = 0
        ni = x + di[k]
        nj = y + dj[k]
        flag = 0
        while matrix[ni][nj] == stone:
            ni += di[k]
            nj += dj[k]
            cnt += 1
        result[k] = cnt # 방향마다 카운트 체크해줌
        print(result)
    for t in range(4):
        if result[t] + result[t+4] == 4:
            answer = i+1
            flag = 1
            break
    if flag:
        break
else:
    answer = -1
print(answer)