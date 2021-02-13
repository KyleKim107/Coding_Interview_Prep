import sys
a =[0]*10001
N = int(sys.stdin.readline())
for _ in range(N):
    num = int(sys.stdin.readline())
    a[num]+= 1
for i in range(10001):
    for _ in range(a[i]):
        print(i) 