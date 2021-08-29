
import sys

def find(parent ,x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union( parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
parent = [0]*(N + 1)
for i in range(N + 1):
    parent[i] = i
for _ in range( M):
    a, b = map(int, sys.stdin.readline().split() )
    union(parent, a, b)
cnt = 0
# print(parent)
for i in range(2, len(parent)):
    if find(parent , i) == 1:
        cnt += 1
print(cnt)


