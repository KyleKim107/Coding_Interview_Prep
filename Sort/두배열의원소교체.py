N,K = map(int,input().split())
a,b = [],[]
a= list(map(int, input().split()))
b= list(map(int, input().split()))
a = sorted(a)
b = sorted(b , reverse = True)
k = 0 
flag = False
for i in range(N):
    for j in range(N):
        if k == K:
            flag = True
            break
        if a[i]<b[j]:
            k += 1
            a[i],b[j] = b[j],a[i]
            break
    if flag == True:
        break
print(sum(a))
        

