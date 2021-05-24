import sys
N = int(sys.stdin.readline())
cnt = N
for _ in range(N):
    st = list(map(str , sys.stdin.readline().strip()))
    flag = True
    for i in range(1,len(st)):
        if st[i-1] != st[i] and st[i] in st[:i]:
            cnt -=1 
            break       
print(cnt)



# import sys
# N = int(sys.stdin.readline().strip())

# result = 0
# for _ in range(N):
#     word = list(sys.stdin.readline().strip())
#     index = 0
#     while index < len(word)-1:
#         if word[index] == word[index+1]:
#             word.pop(index+1)
#         else:
#             index += 1
#     if len(word) == len(set(word)):
#         result += 1

# print(result)
