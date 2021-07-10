n,m = map(int, input().split())
data = list(map(int, input().split()))
count = 0
interval_sum = 0
end = 0

# start를 차례대로 증가시키며 반복
for start in range(n):
    # end 를 가능한 만큼 이동시키기
    while interval_sum < m and end < n:
        print('interval_sum',interval_sum,'end', end)
        interval_sum += data[end]
        end += 1
    print('out')
    # 부분합이 m일 때 카운트 증가
    if interval_sum == m:
        count += 1
    interval_sum -= data[start]
    
print(count) # 3