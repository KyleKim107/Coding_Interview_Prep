import sys
from collections import deque

N,M,K,X = map(int,sys.stdin.readline().split())
distance = [-1] * (N + 1)
graph = [[] for _ in range(N+1)]
for _ in range(M):
    x,y = map(int, sys.stdin.readline().split() )
    graph[x].append(y)

# print(l)
a = deque([X])
distance[X] = 0
while a:
    curr =a.popleft()
    for city in graph[curr]:
        if distance[city]== -1:
            distance[city] = distance[curr] + 1
            a.append(city)
flag = True
for i in range(1,len(distance)):
    if distance[i] == K:
        flag = False
        print(i)
if flag:
    print(-1)





