import heapq
import sys
a = []
N = int(input())
for _ in range(N):
    num = int(sys.stdin.readline())
    heapq.heappush(a,num)

total = 0
while len(a) > 1:
    
    sumVal= heapq.heappop(a) + heapq.heappop(a)
    total += sumVal
    heapq.heappush(a, sumVal)
    # print(list(a))

print(total)
