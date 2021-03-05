import sys
l=[0]
c=0
for k in range(int(input())):
    n=int(sys.stdin.readline())
    while l:
        if n>=l[-1]:
            l.pop(-1)
        else:
            break
    l.append(n)
    print(l)
    c+=len(l)-1
print(c)
# 10
# 3
# 7
# 4
# 12
# 2