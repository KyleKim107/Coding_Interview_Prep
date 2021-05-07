import sys
N = int(sys.stdin.readline())
a = []
for _ in range(N):
    age,name = sys.stdin.readline().split()
    a.append([int(age),name])
a = sorted(a , key = lambda x : x[0])
for age, name in a:
    print(f'{age} {name}')
