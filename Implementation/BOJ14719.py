h, w=map(int, input().split()) # 세로 가로
a=list(map(int, input().split()))
ans=0
for i in range(1, w-1):
    print(max(a[:i]) , max(a[i+1:]), a[i])
    ans+=max(0, min(max(a[:i]), max(a[i+1:])) -a[i])
print(ans)

# 내정답
# N,M = map(int, input().split())
# a = list( [0]* M for _ in range(N))
# arr = list(map(int, input().split()))
# answer, btw = 0, []
# for i in range(M):
#     for j in range(N -1, N - arr[i] -1  , -1):
#         a[j][i] = -1
# # for i in a:
# #     print(i)
# for i in range(len(a)):
#     tmp = a[i]
#     wall = 0
#     st, ed = -1, -1
#     for i in range(len(tmp)):
#         if tmp[i] == -1:
#             wall += 1
#             if wall == 1:
#                 st = i
#             elif wall == 2:
#                 btw.append([st, i ])
#                 wall =1
#                 st = i

# for a in btw:
#     answer += abs(a[0]-a[1]) -1
# print(answer)




