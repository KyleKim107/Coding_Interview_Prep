import sys
G = int(sys.stdin.readline())
P = int(sys.stdin.readline())
parent = [0]*(G+1)
pl = []
for _ in range(P):
    pl.append(int(sys.stdin.readline()))
def find(parent, plane):
    if parent[plane] != plane:
        parent[plane] = find(parent, parent[plane])
    return parent[plane]

def union(parent, plane):
    print('plane', plane)
    a = find(parent, plane) # 1
    print('a', a)
    b = find(parent, plane-1) # 0
    print('b', b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
    


for i in range(len(parent)):
    parent[i] = i
cnt = 0 
for i in range(P):
    plane = pl[i]
    root =find(parent, plane)
    if root != 0:
        union(parent, root) #루트를 넣어줘야 루트부터 밑으로 뻩어나가
        cnt += 1
    else:
        break
# print(parent)
print(cnt)


