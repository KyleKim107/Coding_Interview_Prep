# 퇴사 DP 
n = int(input())
T, P = [0 for i in range(n+1)], [0 for i in range(n+1)]
for i in range(n):
    a,b = map(int, input().split())
    T[i] = a
    P[i] = b
# dp[i]는 i번째날까지 일을 했을 때, 최대값이다. 
dp =[0 for i in range(n+1)]
 
for i in range(len(T)-2, -1, -1):      # 역순으로 진행
    if T[i]+i <= n:       # 날짜를 초과하지 않을 경우.
        dp[i] = max(P[i]+dp[i+T[i]], dp[i+1])   
    else:                 # 날짜를 초과할 경우.
        dp[i] = dp[i+1]
print(dp[0])



# import sys

# def func(currDay ,total, arr ):
#     global maxV
#     if currDay + currDay >= N+1:
#         print(total)
#         maxV = max(maxV,total)
#         return 
#     elif currDay > N +1 :
#         return
    
#     for i in range(currDay+1 , N+1):
#         if currDay +arr[i][0] < N+1:
#             func( currDay + arr[i][0] , total + arr[i][1]   ,arr)
    

    

# maxV = -1e9
# N = int(sys.stdin.readline())
# l = [(0,0)]
# for _ in range(N):
#     a,b =map(int, sys.stdin.readline().split())
#     l.append((a,b))

# func(0 , 0, l)
# print(maxV)