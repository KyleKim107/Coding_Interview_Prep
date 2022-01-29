import os
from itertools import permutations
a, b = map(int, input().split())
list = [0]*a
for num in range(a):
    list[num] = num + 1
for line in permutations(list, b):
    for num in line:
        print(str(num) , end= " " )
    print()
 