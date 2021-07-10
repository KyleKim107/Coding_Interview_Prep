N = int(input())
friendsList = list( list() for _ in range((N**2)+1))
a = list( [0]* N for _ in range(N))
for _ in range(N**2):
    tmp = list(map(int, input().split()))
    maxV, nextX,nextY= -1e9, -1,-1
    friends, l = tmp[1:], []
    friendsList[tmp[0]].append(friends)
    for i in range(N):
        for j in range(N):
            cnt =0
            if a[i][j] == 0:
                for dx, dy in [(0,1), (1,0),(-1,0), (0,-1)]:
                    nx, ny=dx + i,dy + j
                    if  0 <= nx < N and 0 <= ny < N :
                        if a[nx][ny] == 0:
                            cnt +=1
                        elif a[nx][ny] in friends:
                            cnt += 5
                if maxV <= cnt:
                    nextX, nextY = i,j
                    maxV = cnt
                    l.append([cnt,i,j])
    l = sorted(l , key = lambda x: (-x[0],x[1],x[2]))
    cnt,nextX,nextY = l[0]
    a[nextX][nextY] = tmp[0]
result = 0
for i in range(N):
    for j in range(N):
        cnt = 0
        for dx, dy in [(0,1), (1,0),(-1,0), (0,-1)]:
            nx, ny=dx + i,dy + j
            if  0 <= nx < N and 0 <= ny < N :
                if a[nx][ny] in friendsList[a[i][j]][0]:
                    cnt += 1
        if cnt > 0:
            result += 10**(cnt-1)
print(result)


