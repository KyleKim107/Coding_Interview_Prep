import sys
N,M = map(int, sys.stdin.readline().split())
par = [0]*(N+1)
sys.setrecursionlimit(10**9)
def find(par, x):
    if par[x] != x:
        par[x] = find(par, par[x])
    return par[x]

def union(par, a, b):
    a = find(par, a)
    b = find(par,b)
    if a < b:
        par[b] = a
    else:
        par[a]= b


for i in range(len(par)):
    par[i] = i
for i in range(M):
    cmd, A,B =map(int, sys.stdin.readline().split())
    if cmd == 0:
        union(par, A,B)
    if cmd == 1:
        a =find(par , A)
        b =find(par , B)
        if a == b:
            print('YES')
        else:
            print('NO')
# print(find(par , A))
# print(par)

