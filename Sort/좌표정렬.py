import sys
N = int(sys.stdin.readline())
a= []
for _ in range(N):
    x,y = sys.stdin.readline().split()
    a.append((int(x),int(y)))
a = sorted(a, key=lambda x: (x[1], x[0]))
for i in range(len(a)):
    print(a[i][0], end = ' ')
    print(a[i][1])

