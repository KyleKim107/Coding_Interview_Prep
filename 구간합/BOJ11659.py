import sys
N,M = map(int, sys.stdin.readline().split())
l = list(map(int, sys.stdin.readline().split()))
prefix_sum = [0]
total = 0
for i in l:
    total += i
    prefix_sum.append(total)

# print(prefix_sum)
for _ in range(M):
    a,b = map(int, sys.stdin.readline().split())
    print(prefix_sum[b]-prefix_sum[a-1])