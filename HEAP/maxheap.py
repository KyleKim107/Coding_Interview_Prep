import heapq as hq
import sys
a =[] 
hq.heapify(a)
# print(a)
N = int(sys.stdin.readline())
for _ in range(N):
    num = int(sys.stdin.readline())
    if num != 0:
        hq.heappush(a,-num)
    elif num == 0:
        if len(a)!=0:
            print(-hq.heappop(a))
        else:
            print(0)


# import heapq as hq
# import sys
# a =[] 
# hq._heapify_max(a)
# N = int(sys.stdin.readline().replace(' ', ''))
# for _ in range(N):
#     num = int(input())
#     if num != 0:
#         a.append(num)
#         hq._heapify_max(a)
#     else:
#         if len(a)==0:
#             print(0)
#         else:
#             print(hq._heappop_max(a))

    
# 0
# 2
# 1
# 3
# 2
# 1
# 0
# 0