from itertools import permutations
TC = int(input())
for _ in range(TC):
    N = int(input())
    a = list(map(int, input().split()))
    a.sort()
    first = 0
    for i in range(N -1):
        first +=  a[i] + a[i+1]
    print(first)









