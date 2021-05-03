import heapq as hq
import sys
a =[] 
hq.heapify(a)
# print(a)
N = int(sys.stdin.readline())
for _ in range(N):
    num = int(sys.stdin.readline())
    hq.heappush(a,num)
    print(a.pop(len(a)//2))