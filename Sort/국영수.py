N = int(input())
a = []
for _ in range(N):
    name, liter , english, math = input().split()
    a.append((name, int(liter) , int(english), int(math)))

a.sort(key=lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in range(len(a)):
    print(a[i][0])
