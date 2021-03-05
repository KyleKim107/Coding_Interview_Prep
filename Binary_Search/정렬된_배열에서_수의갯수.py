import sys
# import bisect
from bisect import bisect_left,bisect_right

def BisectFinder(a ,target):
        left = bisect_left(a, target)
        right = bisect_right(a, target)
        print((left,right))
        return right - left

n,x = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))

result = BisectFinder(a, x)
if result == 0:
    print(-1)
else:
    print(result)

