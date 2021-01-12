import sys

n  = map(int, sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
a.sort()
cnt, ans = 0, 0

for i in range(len(a)):
    cnt += 1
    if i <= cnt:
        ans += 1
        cnt = 0
print(ans)

