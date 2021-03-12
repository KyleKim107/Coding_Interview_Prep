

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


T = int(input())
for test_case in range(1, 1 + T):
    N, M, K = map(int, input().split())
    flask = [list(map(int, input().split())) + [0] * K for _ in range(N)] 
    for i in range(K):
        flask.append(list([0] * (K+M)) )
    Live = [[] for _ in range(10+1)]  
    result = 0
    for i in range(N):
        for j in range(M):
            if flask[i][j] > 0:
                Live[flask[i][j]].append([i, j, flask[i][j]])
    for _ in range(K):
        for life in range(10, -1, -1):  
            if len(Live[life]):
                cells = Live[life]
                dead ,newGENE= [],[]
                for i in range(len(cells)-1, -1, -1):
                    cells[i][2] -= 1  # level 감소
                    x, y, level = cells[i]
                    if level == - life:  # unactivated
                        dead.append(i)
                    if level == -1:  # reproducing
                        for d in range(4):
                            nx, ny = (x + dx[d]) % (N + K) , (y + dy[d]) % (M + K)
                            if flask[nx][ny] == 0: 
                                flask[nx][ny] = life
                                newGENE.append([nx, ny, life]) # 추가
                if len(newGENE) > 0:
                    for cell in newGENE:
                        Live[life].append(cell)
                for idx in dead:  
                    Live[life].pop(idx)
    # 활성 셀 개수 세기
    cnt = 0
    for i in range(10):
        cnt += len(Live[i])
    print('#%d %d' % (test_case , cnt) )



