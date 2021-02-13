import sys
N = int(sys.stdin.readline())
a=[]
for _ in range(N):
    years, name = sys.stdin.readline().split()
    a.append((int(years), name))
a = sorted(a,key = lambda x:x[0])
# print(a)
for i in range(len(a)):
    print(a[i][0], end=' ')
    print(a[i][1])

