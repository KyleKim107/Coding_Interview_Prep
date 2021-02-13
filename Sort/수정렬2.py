# import sys
# a = [0] *(1000000+1)
# N = int(sys.stdin.readline())
# for _ in range(N):
#     a[int(sys.stdin.readline())]=1
# for i in range(len(a)):
#     if a[i] != 0:
#         for _ in range(a[i]):
#             print(i)


import sys
a =[0]*1000001
N = int(sys.stdin.readline())
for _ in range(N):
    num = int(sys.stdin.readline())
    a[num]+= 1
for i in range(1000001):
    if a[i] != 0:
        print(i) 



# import sys
# n = int(sys.stdin.readline())
# a = sorted(list(map(int,sys.stdin.read().split())))
# print('\n'.join(map(str,a)))
    