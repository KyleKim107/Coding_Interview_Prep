

from sys import stdin
from collections import deque
read = stdin.readline
N = int(read())
dic = {}
for i in range(N +1):
    dic[i] = []
for _ in range(N):
    tmp = list(map(int, read().split()))
    for i in range(1,len(tmp) -1, 2):
        dic[tmp[0]].append((tmp[i], tmp[i+ 1]))
answer = []
def bfs(i,):
    visit = [-1]* (N + 1)
    q = deque([(i,0)])
    visit[i] = 0
    cnt = 0
    while q:
        next, cost = q.popleft() 
        for node, Nextcost in dic[next]:
            if visit[node] == -1:
                visit[node] = cost + Nextcost
                q.append((node, visit[node]))
    # print(visit)
    maxV = max(visit)
    for j in range(1,len(visit)):
        if visit[j] == maxV:
            return j, maxV

nex, maxV = bfs(1)
nex, maxV = bfs(nex)
print(maxV)
# print(max(answer))




    