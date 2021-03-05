import sys

n,c = map(int, input().split(' '))
a=[]
for _ in range(n):
    a.append(int( input()))
start = 1
end = a[-1] - a[0]
result = 0
a.sort()
# print( a)
while(start <= end):
    mid = (end + start)//2 
    cnt = 1
    value = a[0]
    for i in range(1,n):
        if a[i] >= (value + mid):
            # print((a[i],value + mid ))
            value = a[i]
            cnt += 1
    if cnt >= c:
        result = mid
        start = mid +1
    else:
        end = mid -1
    
print(result)


    