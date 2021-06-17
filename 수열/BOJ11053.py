n = int(input())
seq = list(map(int, input().split()))
dp = [0] * 1001

for s in seq:
    print(dp[:s])
    dp[s] = max(dp[:s]) + 1

print(max(dp))

# import sys
# N = int(sys.stdin.readline())
# arr = list(map(int, sys.stdin.readline().split()))
# result = [1] * N
# dp = [1]*N
# for i in range(1, N):
#     for j in range(i):
#         if arr[j] < arr[i]:
#             result[i] = max(result[i], result[j]+1)
            
# print(max(result))


# 10
# 10 20 10 30 20 50 10 10 10 60