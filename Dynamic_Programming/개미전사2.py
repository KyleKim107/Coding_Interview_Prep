N = int(input())
a =  [0]+list( map(int, input().split()))
d = [0]*101
# print(a)
d[1] = a[1]
d[2] = max(a[1], a[2])
for i in range(3, len(a)):
    d[i] = max(d[i-1], d[i-2]+a[i])
print(d[len(a)-1])

