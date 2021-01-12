import sys

N,M = map(int, sys.stdin.readline().split())
a = [ list( map( int, sys.stdin.readline().split())) for _ in range(N) ]
tmp = []
low =[]
for line in a:
    low = line
    min_val = min(low)
    tmp.append(min_val)
tmp.sort()
print(tmp[-1])