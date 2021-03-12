T = int(input())
d = [[0, 1], [1, 0]]
 
def DFS(i, j, s):
    global ans
    s += maps[i][j]
    if s > ans:
        return
    if i == N-1 and j == N-1:
        ans = s
        return 
 
    for idx in range(2):
        nextI, nextJ = i + d[idx][0], j + d[idx][1]
        if nextI < N and nextJ < N:
            DFS(nextI, nextJ, s)
    
 
for t in range(1, T+1):
    N = int(input())
    ans = 99999999
    maps = []
    for i in range(N):
        maps.append(list(map(int, input().split())))
    print(maps)
    DFS(0, 0, 0)
    print('#%d %d' % (t, ans) )
