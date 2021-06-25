
N = int(input())
a = list(list( map(int, input().split()))for _ in range(N-1))
K = int(input())

def func(sum , curr , big):
    global minV
    if  curr == N-1:
        minV = min(minV ,sum)
        return
    if curr > N -1:
        return
    func(sum+a[curr][0] , curr + 1 , big)
    func(sum+a[curr][1] , curr + 2 , big)
    if big:
        func(sum+K , curr + 3 , big -1)
minV = 1e9
func( 0, 0 ,1 )
# print(a)
print(minV)


























# minV = 1e9
# l = len(a)
# def func(sum, to, big):
#     global minV
#     if to == l:
#         minV = min(minV, sum)
#         return
#     if to > l:
#         return

#     func(sum + a[to][0], to + 1 , big)
#     func(sum + a[to][1], to + 2 , big)

#     if big:
#         func(sum + K, to + 3 , big-1)
# func(0,0,1)

# print(minV)














# dp = [0]* N
# dp[0] = a[0][0]
# dp[1] = min( dp[0] + a[1] , k )