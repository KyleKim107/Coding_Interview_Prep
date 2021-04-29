import sys

input = sys.stdin.readline

n = int(input())
list_n = list(str(n))
m = int(input())
a = [1 for _ in range(10)]

if m != 0:# 만약 고장난 키가 있다면
    broken = list(map(int, input().split()))
    for i in broken:
        a[i] = 0

cnt = abs(n - 100) # 목표채널에서 100을 뺴?
for i in range(1000001):
    list_i = list(str(i))
    print(list_i)
    flag = 0
    for c in list_i:
        if a[int(c)] == 1: #버튼이 있을때
            continue
        else:# 버튼이 고장났을떄
            flag = 1
            break

    if flag:# 버튼이 고장났을떄
        continue
    else: # 5457 - 5457 + 4
        cnt = min(cnt, abs(n - i) + len(list_i))

print(cnt)



# import sys

# def upNUM(currNUM):
#     downN, upN = -1 ,-1
#     ls1 = []
#     for i in range(currNUM, 10):
#         if buttons[i] == 1:
#             ls1.append(i)
#     return min(ls1)

#     ls2 = []
#     print('downNUM',"currNUM",currNUM)
#     for i in range(currNUM ,0, -1 ):
#         if buttons[i] == 1:
#             ls2.append(i)
    
#     if len(ls1) == 0:
#         upN = max(ls2)
#     else:
#         upN = min(ls1)
#     if len(ls2) == 0:
#         downN = min(ls1)
#     else:
#         downN = max(ls2)
#     return (upN , downN)

# buttons = [1]*10
# curCh = sys.stdin.readline().replace('\n','')
# num = int(sys.stdin.readline())
# disabled = list(map(int, sys.stdin.readline().split()))
# if int(curCh) == 100:
#     print(0)
# else:
#     for i in disabled:
#         buttons[i] = 0
#     st = []
#     for i in range(len(curCh)):
#         currNUM = int(curCh[i])
#         print(currNUM)
#         #up
#         if buttons[currNUM] == 0 and not sum(buttons) == 1:
#             upN, downN = upNUM(currNUM)
#             print((upN,downN))
#             st.append(min(abs(currNUM - upN ) , abs(currNUM - downN)))
#         else:
#             st.append(currNUM)

#     print(st)