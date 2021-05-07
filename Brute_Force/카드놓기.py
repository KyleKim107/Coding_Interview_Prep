import sys
from itertools import permutations
N = int(input())
K = int(input())
a = [sys.stdin.readline().strip() for _ in range(N)]
answer = set()
for line in list(permutations(a,K)):
    answer.add(''.join(line))
print(answer)
print(set(list(permutations(a,K))))



print(len(answer))