import sys
g,s = map(int, sys.stdin.readline().split())
W = list(sys.stdin.readline().strip())
S = list(sys.stdin.readline().strip())
tmpW = [0]*52
tmpS = [0]*52
cnt  = 0
for ch in W:
    if 'a' <= ch <= 'z':
        tmpW[ord(ch) - ord('a')] += 1
    else:
        tmpW[ord(ch) - ord('A') + 26 ] += 1
length = 0
start = 0
for i in range(len(S)):
    if 'a' <= S[i] <= 'z':
        tmpS[ord(S[i]) - ord('a')] += 1
    else:
        tmpS[ord(S[i]) - ord('A') + 26 ] += 1
    length += 1

    if length == g:
        if tmpW == tmpS:
            cnt += 1
        if 'a' <= S[start] <= 'z':
            tmpS[ord(S[start]) - ord('a')] -= 1
        else:
            tmpS[ord(S[start]) - ord('A') + 26] -= 1
        start += 1
        length -= 1

print(cnt)






# 4 11
# cAda
# AbrAcadAbRa

























# import sys
# from itertools import permutations
# n, m = map(int, input().split())
# w = sys.stdin.readline().strip()
# s = sys.stdin.readline().strip()

# wl = [0] * 52
# sl = [0] * 52

# # w의 각 알파벳마다 등장하는 부분 +1
# for i in range(n): #0 ~ 25 a ~ z
#     if 'a' <= w[i] <= 'z':
#         wl[ ord(w[i]) - ord('a') ] += 1 # a -0
#     else:
#         wl[ord(w[i]) - ord('A') + 26] += 1 # A - 26

# start, length, count = 0, 0, 0

# for i in range(m):
#     print(i)
#     if 'a' <= s[i] <= 'z':
#         sl[ord(s[i]) - ord('a')] += 1
#     else:
#         sl[ord(s[i]) - ord('A') + 26] += 1
#     length += 1

#     if length == n:
#         if wl == sl: # ele가 같은경우
#             print(wl)
#             print(sl)
#             count+=1
#         if 'a' <= s[start] <= 'z':
#             sl[ord(s[start]) - ord('a')] -= 1
#         else:
#             sl[ord(s[start]) - ord('A') + 26] -= 1
#         start += 1
#         length -= 1


# print(count)


