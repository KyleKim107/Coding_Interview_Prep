import sys
read = sys.stdin.readline
def bfs(stack):
    c = 0
    while stack:
        #print(c)
        #print('\n'.join(' '.join(str(i) for i in j) for j in Map))
        tmplist = []
        for s in stack:
            x,y,z = s[0], s[1], s[2]
            if x+1 < X and Map[x+1+X*z][y] == 0:
                tmplist.append((x+1,y,z))
                Map[x+1+X*z][y] = 1
            if x-1>= 0 and Map[x-1+X*z][y] == 0:
                tmplist.append((x-1,y,z))
                Map[x-1+X*z][y] = 1
            if y+1 < Y and Map[x+X*z][y+1] == 0:
                tmplist.append((x,y+1,z))
                Map[x+X*z][y+1] = 1
            if y-1>= 0 and Map[x+X*z][y-1] == 0:
                tmplist.append((x,y-1,z))
                Map[x+X*z][y-1] = 1
            if z> 0 and Map[x+X*(z-1)][y] == 0:
                tmplist.append((x,y,z-1))
                Map[x+X*(z-1)][y] = 1
            if z< H-1 and Map[x+X*(z+1)][y] == 0:
                tmplist.append((x,y,z+1))
                Map[x+X*(z+1)][y] = 1
            
            stack = tmplist
        c+=1    
    return c-1  
                       
def check(c):
    for x in Map:
        for i in x:
            if i == 0:
                c = -1
                return c
    return c

Y,X,H = map(int,read().split())
Map = []
stack = []
for z in range(H):
    for i in range(X):
        a = list(map(int,read().split()))
        for j in range(len(a)):
            if a[j] == 1:
                stack.append((i,j,z))
        Map.append(a)
print(Map)
c = bfs(stack)
c = check(c)
print(Map)
print(c)