from itertools import permutations
TC = int(input())
for _ in range(TC):
    n = int(input())
    # print(n)
    a = list(map(int, input().split()))
    if n != 1:
        leng = len(a)
        half = leng // 2
        for line in permutations(a,leng):
            tmp, pre = [], 0
            nPair = leng//n
            for i in range(nPair ,len(line)+1, nPair):
                tmp.append(line[pre:i] )
                pre = i
            # print(tmp)
            flag = True
            goal, cnt  = len(tmp),0
            for line in tmp:
                if sum(line) % 2 == 1:
                    cnt += 1

            if cnt == goal:
                print("Yes")
                flag = False
                break
        if flag:
            print("No")
    else:
        if sum(a) % 2 == 1:
            print("Yes")
        else:
            print("No")
    
    
# if sum(a) % 2 ==0:
#     #     print("Yes")
#     # else:
#     #     print("No")