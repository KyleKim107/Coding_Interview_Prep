import sys
from itertools import combinations

N,M = map(int,sys.stdin.readline().split())
# a =[ list( map( int, sys.stdin.readline().split())) for _ in range(N) ]
chickList = []
city = []
for i in range(N):
    a = list(map(int,sys.stdin.readline().split() ))
    for j in range(N):
        if a[j] == 2:
            chickList.append((i+1,j +1))
        elif a[j] == 1:
            city.append((i+1,j+1))            
# 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산

candidates = list(combinations(chickList, M))
print(candidates)
def cal(candidate):
    tmp = 0
    for x1,y1 in city:
        less = 1e9
        for x2,y2 in candidate:
            less = min( less , abs(x1-x2) + abs(y1-y2) )
        tmp += less
    return tmp

ans = 1e9
for candidate in candidates:
    ans =min( ans, cal(candidate))
print(ans)




#         x,y = city[i]
#         q.append((x,y))
#         vis[i][j] = 1
#         while q:
#             x,y = q.popleft()
#             for dx, dy in dir:
#                 nx,ny = x + dx , y + dy
#                 if nx < 0 or  nx >= N or ny < 0 or ny >= n:
#                     continue
#                 if vis[nx][ny] == 0:
#                     vis[nx][ny] = vis[x][y] +1
#                     q.append((nx,ny))
                    
            











