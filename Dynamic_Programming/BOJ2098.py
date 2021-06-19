import sys
input=sys.stdin.readline
sys.setrecursionlimit(10000)
INF = sys.maxsize
n=int(input())
adj=[list(map(int,input().split()))for _ in range(n)]
dp=[[INF]*(1<<n)for _ in range(n)]
def dfs(current,visit): # 0,1
    if visit==(1<<n)-1:# n - 1() 개 도시를 모두 순환했을 때
        if adj[current][0]==0: # 없다면 INF 리턴
            return INF 
        else:
            return adj[current][0] # 마지막 도시에서 0으로 돌아갈 경로가 있다면 리턴
    if dp[current][visit]!=INF: # 이미 계산된 것이니 리턴?
        return dp[current][visit]
    for i in range(1,n): # 0에서 시작하는것을 전제로
        if not visit & (1 << i) and adj[current][i]!=0 : #현재 점은 계산 ㄴㄴ
            # print(' currnet', current,'visit',visit ,'1<<i',1<<i,'visit&(1<<i)',visit&(1<<i))
            dp[current][visit] = dfs(i, visit|(1<<i) ) + adj[current][i]
    return dp[current][visit]
print(dfs(0,1)) # 0에서 시작해 먼저 1로간다
print(dp[0][1])

# from sys import stdin
# read = stdin.readline
# N = int(read())
# a = list( list(map(int, read().split() )) for _ in range( N) )
# def func(visit , N, val,curr):sdf
#     global minV
#     if len(visit) == N:
#         val += a[curr][visit[0]]
#         minV = min(minV, val)
#         return
#     elif len(visit) > 4:
#         return
#     for i in range(N):
#         if i not in visit:
#             visit.append(i) 
#             val += a[curr][i]
#             func(visit , N, val,i)
#             val -= a[curr][i]
#             visit.pop()
# minV = 1e9
# visit = []
# val = 0
# for curr in range(N):
#     visit.append(curr)
#     func(visit,N, val, curr)
#     visit.pop()
# print(minV)