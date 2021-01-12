import sys

N,M,K = map(int, sys.stdin.readline().split())
a = list( map(int,sys.stdin.readline().split()) )

tmp = [ 0 for _ in range(N)]
a.sort()
size = len(a)
#print(a)
ans = 0, 
res1 = 0
res2 = 0
n = int(M / K)
m = M % K
res1 += (a[size -1] * n * K) # greatest * 2 
res2 += (a[size -2] * m)

print(res1 + res2)

    

# h1 = a[1]
# h2 = a[1]
# for i  in range(len(a)):
#     if h1 < a[i]:
#         h1 = a[i]
#     elif h2 < a [i]:
#         h2 = a[i]



# 5 8 3
# 2 4 5 4 6