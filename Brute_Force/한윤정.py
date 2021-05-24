
import sys
from itertools import combinations

N,M =  map(int, sys.stdin.readline().split())
dislike = [[0]*(N+1) for _ in range(N+1)]

for _ in range(M):
    x,y = map(int,input().split())
    dislike[x][y]=1
    dislike[y][x]=1
# print(dislike)
a = list(i for i in range(1,N+1))
com = list(combinations(a, 3))
answer = len(com)
flag = True
for a,b,c in com:
    if dislike[a][b] or dislike[b][c] or dislike[a][c]:
        answer -= 1
print(answer)