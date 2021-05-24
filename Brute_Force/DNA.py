import sys
N,M = map(int, sys.stdin.readline().split())
# a = list(list( map(str, sys.stdin.readline().strip()) ) for _ in range(N))
arr = []
for _ in range(N):
    arr.append(list(map(str,sys.stdin.readline().strip())))
answer = ''
ham = 0
for i in range(M):
    a,t,g,c = 0,0,0,0
    for j in range(N):
        if arr[j][i] == 'T':
            t += 1
        elif arr[j][i] == 'A':
            a += 1
        elif arr[j][i] == 'G':
            g += 1
        elif arr[j][i] == 'C':
            c += 1
    if max(t,a,g,c) == a:
        answer += 'A'
        ham += (t+g+c)
    elif max(t,a,g,c) == c:
        answer += 'C'
        ham += (a+g+t)
    elif max(t,a,g,c) == g:
        answer += 'G'
        ham += (a+t+c)
    elif max(t,a,g,c) == t:
        answer += 'T'
        ham += (a+g+c)
print(answer)
print(ham)




































# n, m = map(int, input().split()) 
# arr = []  # 문자열을 list형식으로 담아준다
# for i in range(n):
#     arr.append(list(map(str, input())))
# cnt, hap = 0, 0
# result = ''
# # print(arr)
# for i in range(m):
#     # print(i)
#     a, c, g, t = 0, 0, 0, 0
#     for j in range(n): # 위에서 아래로 한글자씩 갯수를 구한다
#         if arr[j][i] == 'T':
#             t += 1
#         elif arr[j][i] == 'A':
#             a += 1
#         elif arr[j][i] == 'G':
#             g += 1
#         elif arr[j][i] == 'C':
#             c += 1
#     if max(a, c, g, t) == a:
#         result += 'A'
#         hap += c + g + t 
#     elif max(a, c, g, t) == c:
#         result += 'C'
#         hap += a + g + t
#     elif max(a, c, g, t) == g:
#         result += 'G'
#         hap += a + c + t
#     elif max(a, c, g, t) == t:
#         result += 'T'
#         hap += c + g + a
# print(result)
# print(hap)
