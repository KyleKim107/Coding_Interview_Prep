n=int(input())
A=list(map(int,input().split()))
m=max(A)
upDP=[0]*(m+1)
downDP=[0]*(m+1)
R=[0]*(n+1)
for i in range(n):
    print(upDP[:A[i]])
    upDP[A[i]]=max(upDP[:A[i]])+1
    downDP[A[n-i-1]]=max(downDP[:A[n-i-1]])+1
    R[i]+=upDP[A[i]]
    R[n-i-1]+=downDP[A[n-i-1]]
print(max(R)-1)