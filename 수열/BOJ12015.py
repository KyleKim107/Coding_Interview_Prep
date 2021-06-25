from sys import stdin
read = stdin.readline
N = int(read())
l = list(map(int, read().split()))
dp = [0] *(1000001)
for  sep in l:
    dp[sep] = max(dp[:sep]) + 1
print(max(dp))