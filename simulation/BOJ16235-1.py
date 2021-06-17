from sys import stdin
read = stdin.readline
N,M,K = map(int, read().split())
nutri_win = list(list( map(int, read().split()) ) for _ in range(N))
nutri = list( list( 5 for _ in range(N)) for _ in range(N))
tree = list(list([] for _ in range(N)) for _ in range(N))
for _ in range(M):
    x,y,z = map(int, read().split())
    tree[x-1][y-1].append(z)

def spring():
    for_autom = []
    for i in range(N):
        for j in range(N):
            if tree[i][j]:
                tmp, dead = [], 0
                tree[i][j].sort()
                for k in tree[i][j]:
                    if (nutri[i][j] - k) >= 0:
                        tmp.append(k+1)
                        nutri[i][j] -= k
                        if (k+1)% 5 == 0:
                            for_autom.append((i,j))
                    else:
                        dead += k //2
                nutri[i][j] += dead
                tree[i][j] = tmp
    return for_autom

def autom(for_autom):
    for x,y in for_autom:
        for dx,dy in [(-1,0),(-1,-1),(0,-1),(1,-1),(1,0),(1,1),(0,1),(-1,1)]:
            nx, ny = x + dx , y + dy
            if 0 <= nx < N and 0 <= ny < N :
                tree[nx][ny].append(1)
def winter():
    for i in range(N):
        for j in range(N):
            nutri[i][j] += nutri_win[i][j]

for _ in range(K):
    for_autom = spring()
    if for_autom:
        autom(for_autom)
    winter()

    
cnt = 0
for i in range(N):
    for j in range(N):
        if len(tree[i][j]) > 0:
            cnt += len(tree[i][j])
print(cnt)





