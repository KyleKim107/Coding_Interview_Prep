import sys
N,M,R = map(int, sys.stdin.readline().split())
a = list( list( map( int, sys.stdin.readline().split()))for _ in range(N) )

for _ in range(R):
    n,m,x,y = N,M,0,0
    for l in range((min(N,M)//2)):
        print(l)
        tmp =a[x][y]
        for i in range(m-1): #위
            a[x][y + i] = a[x][y + i + 1]

        for i in range(n-1): # 오른쪽
            a[x+i][y+m-1] = a[x+ i+1][y+m-1]
        
        for i in range(m-1): #아래
            a[x+n-1][y+m-1-i] = a[x+n-1][y+m-i-2]
        
        for i in range(n-1):
            a[x + n - i - 1][y] = a[x+n-2-i][y]
        a[x+1][y] = tmp
        
        x+= 1
        y+= 1
        n-= 2 # 2씩 감소해 준다고 해도 x와 y랑 같이 쓰이면 결굴 하나만 뺸거 처럼 됨
        m-= 2
for i in range(len(a)):
    print( a[i], end = '\n')
