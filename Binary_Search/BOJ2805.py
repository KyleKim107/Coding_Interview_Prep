N,M = map(int, input().split())
a = list(map(int,input().split()))
start ,end  = 1,max(a)

while start <= end:
    mid = (start + end) // 2
    cut = 0
    for num in a:
        if num > mid:
            cut +=  num - mid
    if cut >= M: # 덜 잘라야해 하단바를 올려
        start = mid +1
    else:
        end = mid - 1 # 더 잘라야해 상단바를 내려
print(end)
