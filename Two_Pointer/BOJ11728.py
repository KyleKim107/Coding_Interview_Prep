# 사전에 정렬된 리스트 A와 B 선언
n, m = map(int, input().split())
a = list(map(int,input().split()))
b = list(map(int,input().split()))

# 리스트 A와 B의 모든 원소를 담을 수 있는 크기의 결과 리스트 초기화
result = [0] * (n + m)
i = 0 # 배열 A를 위한 포인터
j = 0 # 배열 B를 위한 포인터
k = 0 # result 포인터

# 모든 원소가 결과 리스트에 담길 때까지 반복
while i < n or j < m:
    # 리스트 B의 모든 원소가 처리되었으나,리스트 A의 원소가 더 작을 때
    if j >= m or (i < n and a[i] <= b[j]):
        # 리스트 A의 원소를 결과 리스트로 옮기기
        result[k] = a[i]
        i += 1
    # 리스트 A의 모든 원소가 처리되었거나, 리스트 B의 원소가 더 작을 때
    else:
        # 리스트 B의 원소를 결과 리스트로 옮기기
        result[k] = b[j]
        j += 1
    k += 1
    
# 결과 리스트 출력
for i in result:
    print(i, end=' ') # 1 2 3 4 5 6 8