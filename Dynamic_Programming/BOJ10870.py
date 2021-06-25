import sys
N = int(input())
if N <= 1:
    print(N)
    sys.exit(0)
dp = [0] * (N+1)
dp[0],dp[1]= 0,1
for i in range(2,N+1):
    dp[i] = dp[i-1] + dp[i-2]
print(dp[N])