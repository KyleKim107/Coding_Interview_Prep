from sys import stdin

def finder(a , start, end):
    if start > end:
        return -1
    mid = (start + end ) // 2
    if(a[mid] == mid):
        return mid
    elif a[mid] > mid:
        return finder(a, start, mid -1)
    else:
        return finder(a,mid + 1, end)


n = int(stdin.readline())
a = list(map(int, stdin.readline().split()))

result = finder(a ,0, n-1)
print(result)


    

