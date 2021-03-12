import sys;input=sys.stdin.readline
from collections import deque
def bfs(x,y):
    Q=deque([(x,y)])
    mQ=deque()
    visit[x][y]=1
    while Q:
        v,w=Q.popleft()
        mcnt=0
        for i in range(4):
            tx=v+dx[i]
            ty=w+dy[i]
            if tx<0 or tx==N or ty<0 or ty==M:continue
            if visit[tx][ty]:continue
            if ice[tx][ty]!=0:
                visit[tx][ty]=1
                Q.append((tx,ty))
            else:
                mcnt+=1
        if mcnt:
            mQ.append((v,w,mcnt))
    return mQ

dx=[-1,1,0,0]
dy=[0,0,-1,1]
N,M=map(int,input().split())
ice=[list(map(int,input().split())) for _ in range(N)]
ans=0
while True:
    cnt=0
    visit=[[0]*M for _ in range(N)]
    for i in range(N-1):
        for j in range(M-1):
            if ice[i][j]!=0 and visit[i][j]==0:
                cnt+=1
                melt=bfs(i,j)
                while melt:
                    mx,my,m=melt.popleft()
                    ice[mx][my]=max(ice[mx][my]-m,0)
    if cnt==0:
        ans=0
        break
    if cnt>=2:
        break
    ans+=1
print(ans)