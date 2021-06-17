
N = int(input())
a = list( map(int, input().split()))
dp = [1]*N
for i in range(len(a)-2 , -1, -1):
    for j in range(len(a)-1 , i, -1):
        if a[i] > a[j]:
            dp[i] = max(dp[i],dp[j]+1 )
print(max(dp))