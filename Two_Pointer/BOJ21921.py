import sys
N, X = map(int, sys.stdin.readline().rstrip().split(' '))
visit = list(map(int, input().split(' ')))
if sum(visit) == 0:
    print('SAD')
else:
    maxV = sum(visit[0:X])
    value = maxV
    cnt =1
    for i in range(X,N):
        value -= visit[i - X]
        value += visit[i]
        if value > maxV:
            maxV = value
            cnt = 1
        elif value == maxV:
            cnt += 1
    print(maxV)
    print(cnt)
