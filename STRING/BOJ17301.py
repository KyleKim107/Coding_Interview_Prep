from itertools import permutations
from sys import stdin
read = stdin.readline
N = int(read())
l = list(list(read().strip()) for _ in range(N))
for i in range(len(l)):
    tmp = l[i]
    n,c = 0,0
    if 'N' in tmp:
        for j in tmp:
            if tmp

