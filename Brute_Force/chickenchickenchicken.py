import sys
from itertools import combinations

N,M =map(int,sys.stdin.readline().split())
answer = 0
num = []
people = list( list(map(int, sys.stdin.readline().split())) for _ in range(N) )
maxV = -1e9

for i in range( M):
    num.append(i)

for line in combinations(num,3):
    answer = 0
    for i in range(N):
        answer += max(people[i][line[0]],people[i][line[1]],people[i][line[2]])
    maxV = max(maxV, answer)
print(maxV)


# 4 6
# 1 2 3 4 5 6
# 6 5 4 3 2 1
# 3 2 7 9 2 5
# 4 5 6 3 2 1