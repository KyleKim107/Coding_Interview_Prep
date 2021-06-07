import sys
input=sys.stdin.readline
def check(visited,num):
    if num>=p:
        return 0

    if dp[visited]!=-1:
        return dp[visited]
    
    tmp=sys.maxsize
    for i in range(n):
        if (visited & (1<<i))==0:
            for j in range(n):
                if i!=j and (visited & (1<<j)):
                    tmp=min(tmp,check(visited|(1<<i),num+1)+arr[j][i])     
    dp[visited]=tmp
    return tmp

n=int(input())
arr=[list(map(int,input().split())) for i in range(n)]
dp=[-1]*(1<<n)
m=input() # YNN
p=int(input()) # at least
cnt = res = 0
for i in range(n): # 0 1 2 3 
    if m[i]=='Y': # Y N N N
        res+=(1<<i)
        # print(1<<i)
        cnt+=1
print(res)
tmp = check(res,cnt)
if tmp == sys.maxsize:
    print(-1)
else:
    print(tmp)