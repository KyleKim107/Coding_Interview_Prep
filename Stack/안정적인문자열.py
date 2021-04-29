# import sys 
# flag = True

# while flag:
#     a = list(map(str,sys.stdin.readline().rstrip()))
#     if a[0] == '-':
#         flag = False
#         break
#     st = a[0:len(a)//2]
#     left = a[len(a)//2  : len(a)]
#     answer = 0
#     for i in range(len(st)):
#         curr = st.pop()
#         if curr == '{' and left[i] == '}' or curr == '}' and left[i] == '{':
#             continue
#         elif curr == '{' and left[i] == '{':
#             answer += 1
#         elif curr == '}' and left[i] == '{':
#             answer += 2
#     # print(answer)

         

    