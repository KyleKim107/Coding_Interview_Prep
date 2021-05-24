import sys
from math import factorial as fac

N= int(sys.stdin.readline())
for _ in range(N):
    n,m = map(int, sys.stdin.readline().split())
    tmp =fac(n)*fac(m-n)
    print(fac(m)//tmp)

# https://zifmfmphantom.tistory.com/13