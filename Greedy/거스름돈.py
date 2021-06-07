import sys 
N = int(sys.stdin.readline())
flag,cnt,prev = True,0,0
while N:
    prev = cnt
    if N % 5 == 0 :
        cnt +=  N //5 
        N = N % 5
    elif N != 1 :
        cnt += 1
        N -= 2
    if prev == cnt :
        flag = False
        break
if flag:
    print(cnt)
else:
    print(-1)

    

            

        
        