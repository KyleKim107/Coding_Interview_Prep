from sys import stdin
read = stdin.readline
V, S = map(int, read().split())
edge = []
for _ in range(S):
    a, b, w = map(int, read().split())
    edge.append((w, a, b))
    
edge.sort(key=lambda x: x[0])
parent = list(range(V + 1))

def union(a, b):
    a = find(a)
    b = find(b)
    if b < a:
        parent[a] = b
    else:
        parent[b] = a

def find(a):
    if a == parent[a]:
        return a
    parent[a] = find(parent[a])  # 경로 압축
    return parent[a]

sum = 0
for w, s, e in edge:
    if find(s) != find(e):
        union(s, e)
        sum += w
print(sum)
# # from sys import stdin

# def find(parent, x):
#     if parent[x] != x:
#         return find(parent, parent[x])
#     return x

# def union(x,y):
#     x = find(parent, x)
#     y = find(parent, y)
#     if x < y:
#         parent[y]= x
#     else:
#         parent[x] = y

# V,E = map(int, input().split())
# parent = [-1]*(V+1)
# for i in range(V+1):
#     parent[i] = i
# print(parent)
# l = []
# for _ in range(E):
#     b,c,d = map( int , input().split() )
#     union(b,c)
#     l.append( (b,c,d) )
# print(parent)
# l =sorted( l , key = lambda x: x[2])
# tmp, cnt  = [], 0
# for i in range(len(l)):
#     a,b,c = l[i]
#     if len(tmp)  < V -1  :
#         tmp.append((a,b,c))
#         cnt += c
#     else:
#         break
# print(cnt)


