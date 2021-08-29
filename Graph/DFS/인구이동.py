import sys
from collections import defaultdict
sys.setrecursionlimit(10**6)

def search(A):
    graph = defaultdict(list)
    bool_map = [[False for _ in range(N)] for __ in range(N)]
    for i in range(N):
        for j in range(N):
            if i < N-1:
                if L <= abs(A[i][j] - A[i+1][j]) <= R: # 밑에
                    graph[(i,j)].append((i+1, j))# 서로 리스트에 더해줘?
                    graph[(i+1,j)].append((i, j))

            if j < N-1:
                if L <= abs(A[i][j] - A[i][j+1]) <= R: 
                    graph[(i,j)].append((i, j+1))
                    graph[(i, j+1)].append((i, j))
    print(graph)
    return graph, bool_map

def dfs(g, visited):
    for new_g in graph[g]: # 
        print(("new_g",new_g))
        if visited[new_g[0]][new_g[1]] == False:
            visited[new_g[0]][new_g[1]] = True
            linked.append(A[new_g[0]][new_g[1]]) # 인구수 넣기
            g_list.append(new_g) # 키 넣기
            dfs(new_g, visited)

rl = lambda: sys.stdin.readline()

N, L, R = map(int, rl().split())

A = []
for _ in range(N):
    A.append(list(map(int, rl().split())))

time = 0
while True:
    graph, visited = search(A)
    if not graph:
        break
    linked, g_list = [], []

    for g in graph: # 그래프 키 프린트하기
        print(g)
        dfs(g, visited)
        print(("g_list",g_list))
        if linked:
            population = int( sum(linked) / len(linked) )
            for fg in g_list:
                A[fg[0]][fg[1]] = population
            linked, g_list = [], []
    time += 1

print(time)

