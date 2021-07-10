N = int(input())
arr = list( list(map(int, input().split())) for _ in range(N))

for a, b in arr:
    tmp = abs(a-b)
    if a< b:
        