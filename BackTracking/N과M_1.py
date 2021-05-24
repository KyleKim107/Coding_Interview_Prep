import sys
from itertools import permutations
n,m = map(int, sys.stdin.readline().split())
print("\n".join(list(map(" ".join, permutations([str(x) for x in range(1, n+1)], m)))))
