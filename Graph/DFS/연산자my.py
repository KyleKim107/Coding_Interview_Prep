import sys
N = int(input())
a = list(map(int , sys.stdin.readline().split()))
plus,minus,multi,div = map(int , sys.stdin.readline().split())
minVal = 1e9
maxVal = -1e9


def calc(index,total):
    global minVal, maxVal,plus,minus,multi,div

    if index == N:
        maxVal = max(maxVal,total)
        minVal = min(minVal, total)
    else:
        if plus >0:
            plus -= 1
            calc(index+1 , total +a[index])
            plus += 1
        if minus >0:
            minus -= 1
            calc(index+1 , total - a[index])
            minus += 1
        if multi >0:
            multi -= 1
            calc(index+1 , total*a[index])
            multi += 1
        if div >0:
            div -= 1
            calc(index+1 , int(total/a[index]))
            div += 1


calc(1,a[0])

print(maxVal)
print(minVal)

    



