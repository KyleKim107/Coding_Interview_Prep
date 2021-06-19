N = int(input())
s = {}
for li in list(map(int, input().split())):
    if li not in s:
        s[li] = 1
M = int(input())
for li in list(map(int, input().split())):
    if li in s:
        print(1, end = ' ')
    else:
        print(0, end = ' ')