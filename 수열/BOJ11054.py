
N = int(input())
a = list( map(int, input().split()))
result = [1] * N
for i in range(1, N):
    for j in range(i):
        if a[j] < a[i]:
            result[i] = max(result[i], result[j]+1)
dp = [1]*N
for i in range(len(a)-2 , -1, -1):
    for j in range(len(a)-1 , i, -1):
        if a[i] > a[j]:
            dp[i] = max(dp[i],dp[j]+1 )
answer = -1e9
for i in range(N):
    answer = max(answer ,result[i]+dp[i] -1 )
print(answer)