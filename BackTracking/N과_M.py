import sys
N, M = map(int,sys.stdin.readline().split())
arr = [0]*M
isused = [0]* (N+1)

def func(arr, isused ,k):
    if k == M:
        print(' '.join(arr))
        return

    for i in range(1,N+1):
        if isused[i] == 0:
            arr[k] = str(i) # if you do not want use JOIN, remove str().
            isused[i] = 1
            func(arr, isused , k +1 )
            isused[i] = 0

func(arr, isused ,0)