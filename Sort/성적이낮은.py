N = int(input())
a = []
for _ in range(N):
    name, grade = input().split()
    a.append((int(grade),name))

a = sorted(a,key=lambda x:x[0])
for i in range(len(a)):
    print(a[i][1] , end = ' ')
