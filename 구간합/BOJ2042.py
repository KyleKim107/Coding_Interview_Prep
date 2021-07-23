N,M,K = map(int, input().split())
l = list( int(input()) for _ in range(N)) 
for _ in range(M+K):
    a,b,c = map(int, input().split())
    if a == 1:
        l[b-1] = c
    else:
        print(sum(l[b-1:c]))
    
