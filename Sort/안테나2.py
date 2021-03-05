import sys
n = int(sys.stdin.readline())
a = sorted(list(map(int, sys.stdin.readline().split())))
b = []
for i in range(len(a)):
    cnt = 0
    for j in range(len(a)):
        if i != j:
            cnt+= abs(a[i] - a[j])
    b.append((i,cnt))
b = sorted(b, key = lambda x:(x[1],x[0]))
print(a[b[0][0]])

    
