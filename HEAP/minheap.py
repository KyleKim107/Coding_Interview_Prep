import heapq as hq
import sys
a =[] 
hq.heapify(a)
# print(a)
N = int(sys.stdin.readline())
for _ in range(N):
    num = int(sys.stdin.readline())
    if num != 0:
        hq.heappush(a,num)
    elif num == 0:
        if len(a)!=0:
            print(hq.heappop(a))
        else:
            print(0)