

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


T = int(input())
for test_case in range(1, 1 + T):
    N, M, K = map(int, input().split())
    my_map = [list(map(int, input().split())) + [0] * K for _ in range(N)] 
    for i in range(K):
        my_map.append(list([0] * (K+M)) )
    active = [[] for _ in range(10)]  # 생명력 1 ~ 10
    result = 0
    # active 채워 넣기
    for i in range(N):
        for j in range(M):
            if my_map[i][j] > 0:
                active[my_map[i][j]].append([i, j, my_map[i][j]])
    print(active)
    # K만큼 시간 지남
    for _ in range(K):
        for life in range(9, -1, -1):  # 생명력이 높은 순으로 번식
            if len(active[life]):
                cells = active[life]
                print(cells)
                # print(cells)
                old ,new= [],[]
                for i in range(len(cells)-1, -1, -1):
                    cells[i][2] -= 1  # HP 감소
                    y, x, HP = cells[i]
                    if HP == -1:  # 활성 시작, 번식
                        # print(("Y,X",y,x))
                        for d in range(4):
                            ny, nx = (y + dy[d]) % (N + K) , (x + dx[d]) % (M + K)
                            # print(("NY,NX",ny,nx))
                            if my_map[ny][nx] == 0: # 다음칸이 0이면 추가
                                my_map[ny][nx] = life
                                new.append([ny, nx, life])
                    if HP == - life:  # 비활성
                        old.append(i)

                for idx in old:  # 비활성 셀 삭제
                    active[life].pop(idx)
                if len(new) > 0:
                    for cell in new:
                        active[life].append(cell)
    # 활성 셀 개수 세기
    result = 0
    for i in range(10):
        result += len(active[i])
    print('#%d %d' % (test_case , result) )




# T = int(input())
# dx = [0, 0, -1, 1]
# dy = [-1, 1, 0, 0]
# for test_case in range(1, 1 + T):
#     N, M, K = map(int, input().split())
#     cnt = 0
#     # cells = list( list( map(int, input().split())) for _ in range(N) )
#     flask = [[0]*(420) for _ in range(420)]
#     Q= list([] for _ in range(10+1))
#     dic = {}
#     cells = list( list( map(int, input().split())) for _ in range(N) )
#     for i in range(len(cells)):
#         for j in range(len(cells[i])):
#             if cells[i][j] != 0:
#                 flask[160 + i][160 + j] = cells[i][j]
#                 Q[cells[i][j]].append((cells[i][j]*2, 160 + i, 160 + j ))
#     for time in range(K+1):
#         for  i in range(10 , 0 ,-1):
#             for _ in range(len(Q[i])):
#                 life, nx,ny= Q[i].pop(0)
#                 if life > i :
#                     if flask[nx][ny] > 0:
#                         flask[nx][ny] = - flask[nx][ny]
#                         cnt += 1
#                     Q[i].append((life - 1, nx,ny))
#                 elif life == i:
#                     Q[i].append((life - 1, nx,ny))
#                     for i in range(4):
#                         xNext,yNext = nx + dx[i], ny + dy[i]
#                         if flask[xNext][yNext] >0 :
#                             continue
#                         flask[xNext][yNext] = i
#                         Q[i].append((i*2 ,xNext,yNext ))
#                 elif i > life and life >0 :
#                     Q[i].append((life-1,nx,ny))
#                 else:
#                     cnt -= 1

#     print(cnt)




#     cnt = 0
    