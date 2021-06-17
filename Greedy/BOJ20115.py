from sys import stdin
read = stdin.readline
N = int(read())
a = sorted(list(map(int, read().split())) , reverse = True)
for _ in range(N -1):
    a[0] += a[-1]/ 2
    a.pop()
if a[0] % 1 != 0:
    print(a[0])
else:
    print(int(a[0]))