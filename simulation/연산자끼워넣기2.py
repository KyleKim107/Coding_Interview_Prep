import sys
N = int(input())
a = list(map(int, sys.stdin.readline().split()))
minV , maxV, curr = 1e9,-1e9,a[0]
plus , minus, mul,div = map(int, sys.stdin.readline().split())

def DFS(curr,plus , minus, mul,div , index ):
    global minV, maxV
    if index == N:
        maxV= max(maxV,curr)
        minV=min(minV,curr)
        return
    if plus > 0:
        print((curr,plus-1 ,minus,mul,div, index ,a))
        DFS( curr + a[index], plus -1 ,minus ,mul ,div , index +1 )
    if minus > 0:
        # curr -= a[index]
        DFS( curr - a[index] , plus  ,minus-1 ,mul ,div , index +1 )
    if mul > 0:
        # curr *= a[index]
        print((curr,plus ,minus,mul-1,div, index ,a))
        DFS( curr * a[index] , plus ,minus ,mul -1,div, index +1 )
    if div > 0:
        print(("curr",curr, "a[index]",a[index] ,"curr//a[index]",curr//a[index]))
        print(("curr",curr, "a[index]",a[index],"int(curr/a[index]",int(curr/a[index])))
        DFS( curr//a[index] , plus ,minus ,mul ,div-1, index +1 )

DFS(curr, plus , minus, mul,div, 1)

print(maxV)
print(minV)

