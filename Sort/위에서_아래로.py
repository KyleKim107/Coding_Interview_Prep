import sys
N = int(input())
a= []
for _ in range(N):
    a.append(int(sys.stdin.readline()))
a=sorted(a, reverse= True)
b = []

print( a)