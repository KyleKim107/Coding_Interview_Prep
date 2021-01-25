import sys
from itertools import permutations
N = int(input())
a = list(map( int, sys.stdin.readline().split()))
tmp = list(map( int, sys.stdin.readline().split()))
com = []
for i in range(len(tmp)):
    if i == 0 and tmp[i] != 0:
        for _ in range(tmp[i]):
            com.append(0)
    if i == 1 and tmp[i] != 0:
        for _ in range(tmp[i]):
            com.append(1)
    if i == 2 and tmp[i] != 0:
        for _ in range(tmp[i]):
            com.append(2)
    if i == 3 and tmp[i] != 0:
        for _ in range(tmp[i]):
            com.append(3)
print(com)
com = list(permutations(com,N-1))
# print(com)
maxVal = -1e9
minVal =  1e9
for pick in com:
    # print(pick)
    total = a[0]
    for i in range(1,len(a)):
        if pick[i-1] == 0:
            total += a[i]
            # print(total)
        elif pick[i-1] == 1:
            total -= a[i]
            # print(total)
        elif pick[i-1] == 2:
            total *= a[i]
            # print(total)
        elif pick[i-1] == 3:
            if total < 0:
                tmp = total
                tmp = -tmp // (a[i])
                total = -tmp
            else:
                total //= a[i]
            # print(total)
    # print(total)
    maxVal = max(total ,maxVal)
    minVal = min(total ,minVal)
print(maxVal)
print(minVal)
