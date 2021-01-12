import sys
def counter1():
    n = int(sys.stdin.readline())
    t,m,s, cnt = 0, 0, 0, 0
    for t in range(n+1):
        for m in range(1,61):
            for s in range(1,61):
                chrsec = str(s)
                chrmin = str(m)
                chrtim = str(t)
                if len(chrsec) > 1 :
                    if chrsec[0] == "3" or chrsec[1] == "3":
                        cnt += 1
                        continue
                elif chrsec[0] == "3":
                    cnt += 1
                    continue

                if len(chrmin) > 1 :
                    if chrmin[0] == "3" or chrmin[1] == "3":
                        cnt += 1
                        continue
                elif chrmin[0] == "3":
                    cnt += 1
                    continue

                if len(chrtim) > 1 :
                    if chrtim[0] == "3" or chrtim[1] == "3":
                        cnt += 1
                        continue
                elif chrtim[0] == "3":
                    cnt += 1
                    continue
    print(cnt)
    
def counter2():
    n = int(sys.stdin.readline())
    t,m,s, cnt = 0, 0, 0, 0
    for t in range(n+1):
        for m in range(1,61):
            for s in range(1,61):
                if '3' in str(t)+str(m)+str(s):
                    cnt += 1
    print(cnt)

counter1()
counter2()

# while t <= n:
#     s += 1
#     chrsec = str(s)
#     if len(chrsec) > 1 :
#         if chrsec[0] == "3" or chrsec[1] == "3":
#             cnt += 1
#     elif chrsec[0] == "3":
#         cnt += 1
#     if s == 60:
#         m += 1
#         s = 0
#         chrmin = str(m)
#         if len(chrmin) > 1 :
#             print((m,s))
#             if chrmin[0] == "3" or chrmin[1] == "3":
#                 cnt += 1
#         elif chrmin[0] == "3":
#             cnt += 1
#     if m == 60:
#         t +=1
#         m = 0
#         chrtim = str(t)
#         if len(chrtim) > 1 :
#             if chrtim[0] == "3" or chrtim[1] == "3":
#                 cnt += 1
#         elif chrtim[0] == "3":
#             cnt += 1