import sys

N,M = map(int, sys.stdin.readline().split())


def func( arr,isused, k):
    if k == M:
        for i in range(len(arr)):
            print(arr[i], end =' ')
        return
    for i in range(1, N+1):
        if isused[i] == 0:
            arr[k] = i
            isused[i] = 1
            func( arr,isused,k+1)
            isused[i] = 0



func([0]*M,[0]*(N+1),0)




