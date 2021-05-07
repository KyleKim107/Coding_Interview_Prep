import sys

def Find(companies , curr):
    global cnt 
    if companies[curr] != curr:    
        dist[curr] += dist[companies[curr]]
        index = Find(companies, companies[curr] )
        companies[curr] = index
        return    
    return curr

def Union(companies , A,B):
    dist[A] = abs(A - B)
    companies[A] = B 


N = int(input())
for _ in range(N):
    numCom = int(input())
    companies,dist = [],[]
    for i in range(numCom+1):
        companies.append(i)
        dist.append(0)

    cmd = sys.stdin.readline()
    while cmd[0] != 'O':
        if cmd[0] == 'I':
            print((int(cmd[2]) , int(cmd[4])))
            Union(companies , int(cmd[2]) , int(cmd[4]))

        if cmd[0] == 'E':
            print(('E', int(cmd[2])))
            cnt = 0
            A = Find(companies, int(cmd[2]))
            print(dist[int(cmd[2])])
        cmd = sys.stdin.readline()
