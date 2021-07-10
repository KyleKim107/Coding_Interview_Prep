from itertools import permutations
N = int(input())
a = list( list(input()) for _ in range(N))
for word in a:
    tmp = []
    for c in word:
        tmp.append(ord(c))
    print(tmp)
    
    
    