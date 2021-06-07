from collections import deque
from sys import stdin
read = stdin.readline
start, end = map(int, read().split())
def bfs(start ,end):
    q, nodes = deque([start]), {start : 0}
    while q:
        curr = q.popleft()
        if curr == end:
            return nodes[curr]
        for nx in (curr + 1, curr-1, curr *2):
            if nx not in nodes and 0 <= nx <= 100000:
                if nx == curr*2:
                    nodes[nx] = nodes[curr]
                    q.appendleft(nx)
                else:
                    nodes[nx] = nodes[curr] + 1
                    q.append(nx)
print(bfs(start ,end))






# from collections import deque
 
# n, k = map(int, input().split())
# MAX = 200000
# time = [-1]*(MAX+1)
 
# queue = deque()
# queue.append(n)
# time[n] = 0
 
# while queue:
#     curr = queue.popleft()
 
#     if curr*2 < MAX and time[curr*2] == -1:
#             time[curr*2] = time[curr]
#             queue.appendleft(curr*2)
 
#     if curr-1 >= 0 and time[curr-1] == -1:
#         time[curr-1] = time[curr]+1
#         queue.append(curr-1)
 
#     if curr+1 < MAX and time[curr+1] == -1:
#         time[curr+1] = time[curr] + 1
#         queue.append(curr+1)
 
#     if curr == k:
#         print(time[curr])
#         break
