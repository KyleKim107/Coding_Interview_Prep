import sys
N = int(sys.stdin.readline())
a = list(list(map( int, sys.stdin.readline().split())) for _ in range(N -1))
k = int(sys.stdin.readline())
dp = [0] * N
for i in range(N):
     
