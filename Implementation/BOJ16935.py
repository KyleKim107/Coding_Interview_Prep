N,M,R = map(int,input().split())
a = list( list( map( int, input().split())) for _ in range(N))
orders = list(map(int,input().split()))

def leftRight():
    for i in range(len(a)):
        a[i] = a[i][::-1]
    return a

def rotateClockwise(n,m):
    N,M = m,n
    tmp =  []
    for row in zip(*a):
        tmp.append(row[::-1])
    return tmp

def rotateCounter(n,m):
    tmp = []
    N,M = m,n
    for row in list(zip(*a))[::-1]: # 반대로 뒤집은 다음에, 삽입하면끝
        tmp.append(row)
    return tmp

for order in orders:
    if order == 1:
        a= list(reversed(a))
    if order == 2:
        a= leftRight()
    if order == 3 :
        a= rotateClockwise(len(a),len(a[0]))
    if order == 4 :
        a = rotateCounter(len(a),len(a[0]))
    if order == 5 or order == 6 :
        n,m = len(a) //2 , len(a) // 2
        tmp = list( [0] * M for _ in range(N) )
        if order == 5:
            for i in range(n): # from 1 to 2
                for j in range(m):
                    tmp[i][j+m] = a[i][j]
            for i in range(n): # from 2 to 3
                for j in range(m, M):
                    tmp[i+n][j] = a[i][j]
            for i in range(n,N): # from 3 to 4
                for j in range(m, M):
                    tmp[i][j-m] = a[i][j]
            for i in range(n,N): # from 3 to 4
                for j in range(m):
                    tmp[i-n][j] = a[i][j]
            a = tmp
        else:
            for i in range(n): # from 1 to 4
                for j in range(m):
                    tmp[i+n][j] = a[i][j]
            for i in range(n): # from 2 to 1
                for j in range(m, M):
                    tmp[i][j-m] = a[i][j]
            for i in range(n,N): # from 3 to 2
                for j in range(m, M):
                    tmp[i-n][j] = a[i][j]
            for i in range(n,N): # from 4 to 3
                for j in range(m):
                    tmp[i][j+m] = a[i][j]
            a = tmp

for line in a:
    for i in range(len(line)):
        print(line[i], end= ' ')
    print()

