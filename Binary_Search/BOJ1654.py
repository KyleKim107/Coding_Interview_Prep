import sys
K, N = map(int, input().split())
lan = [int(sys.stdin.readline()) for _ in range(K)]
start, end = 1, max(lan) #이분탐색 처음과 끝위치

while start <= end :
    mid = (start+end) //2
    cnt = 0
    for num in lan:
        cnt += num // mid
    if cnt >= N: start = mid +1 else: end = mid -1
    #     start = mid +1
    # else:
    #     end = mid -1
print(end)


# K, N = map(int, input().split())
# a =  list( int(input())  for _ in range(K))
# maxV = -1e9
# def Bin(total , target, start, end  ):
#     global maxV


# for i in range( sum(a)//N-1 , 0, -1):
#     cnt = 0
#     for num in a:
#         cnt += num // i
#     if cnt == N:
#         maxV = max(maxV, i)
# print(maxV)
