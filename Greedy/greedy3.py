import sys

N,K = map(int, sys.stdin.readline().split())
cnt = 0
while True:
    if N % K  == 0:
        N = N / K
        cnt += 1
    else:
        N -= 1
        cnt += 1
    if N == 1:
            break

print(cnt)
