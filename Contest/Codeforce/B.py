for _ in range(int(input())):
    N = int(input())
    li = list(map(int, input().split()))
    li.sort()
    mn = 1e12
    for i, n in enumerate(li):
        if i != 0:
            mn = min(mn, li[i] - li[i - 1])
        if n > mn:
            i -= 1
            break
    print(i + 1)
    
# import sys
# from itertools import combinations

# T = int( sys.stdin.readline().strip() )
# for _ in range(T):
#     sys.stdin.readline()
#     a = list(map(int, sys.stdin.readline().split()))
#     maxV = -1e9
#     for i in range(1,len(a)+1):
#         for line in combinations(a, i):
#             # if -3 in line and -2 in line and 0 in line and -4 in line and 1 in line :
#             line = list(line)
#             # print(line)
#             maxNum = max(line)
#             # print(maxNum)
#             line.remove(int(maxNum))
#             line.sort()
#             flag = True
#             for i in range(len(line)-1):
#                 if abs(line[i] + line[i+1] ) >= maxNum:
#                     continue
#                 else:
#                     flag = False
#                     break
#             if flag:
#                 line.append(maxNum)
#                 maxV = max(maxV , len(line))
#     print(maxV)

                


