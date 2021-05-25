for _ in range(int(input())):
    N = int(input())
    li = list(map(int, input().split()))
    old = []
    while len(old) != len(li):
        old = li[:]
        li = list(filter(lambda n: n <= sum(li) / len(li), li))
    print(N - len(li))



# 1
# 1
# 1 2 