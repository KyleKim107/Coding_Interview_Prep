import sys
N = int(sys.stdin.readline())
dp = [0]*1002
dp[1] = 1
dp[2] = 2

for i in range(3,N + 1):
    dp[i] = dp[i-2] + dp[i-1]
print(dp[N]%10007)