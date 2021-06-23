from sys import stdin
V = int(stdin.readline())
E = int(stdin.readline())
parent = list(range(V+1))
def find(x):
    if parent[x] != x:
        return find(parent[x])
    return x
l = []
for _ in range(E):
    a,b,c = map(int, stdin.readline().split())
    l.append((a,b,c))
l = sorted(l , key = lambda x: x[2])
length,cnt = 0,0
for node in l:
    a,b,c  = node
    a = find(a)
    b = find(b)
    if  a != b:
        if a > b:
            parent[a] = b
        else:
            parent[b] = a
        cnt += c
print(cnt)

# from sys import stdin
# V = int(stdin.readline())
# E = int(stdin.readline())
# parent = list(range(V+1))

# def find(x):
#     if parent[x] != x:
#         return find(parent[x])
#     return x

# l = []
# for _ in range(E):
#     a,b,c = map(int, stdin.readline().split())
#     l.append((a,b,c))
# l = sorted(l , key = lambda x: x[2])
# # print(l)
# length,cnt = 0,0

# for node in l:
#     a,b,c  = node
#     a = find(a)
#     b = find(b)
#     if  a != b:
#         if a > b:
#             parent[a] = b
#         else:
#             parent[b] = a
#             cnt += c
# print(cnt)


