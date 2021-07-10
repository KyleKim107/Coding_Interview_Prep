from collections import deque
TC = int(input())
for _ in range(TC):
    n,a,b = map(int,input().split())
    flag,tmp, curr = True, [1],0
    while tmp[-1] <= n*2:
        # print('curr',curr,'tmp[curr]',tmp[curr],'tmp[-1]',tmp[-1])
        # mul =tmp[curr]*a
        # plus =tmp[curr]+b
        tmp.append(tmp[curr]*a)
        tmp.append(tmp[curr]+b)
        curr += 1
        if n in tmp:
            print("Yes")
            flag = False
            break
    print(tmp)
    if flag:
        print("No")
    

