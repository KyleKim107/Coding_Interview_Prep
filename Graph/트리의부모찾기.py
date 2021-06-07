from sys import stdin
from collections import deque
read = stdin.readline
N = int(read().strip())
dic = {}
visit = [False]*(N+1)
parent = [0]*(N+1)
for i in range(1,N+1):
      dic[i] = []
for i in range(N -1):
      a, b = map(int, read().split())
      dic[a].append(b)
      dic[b].append(a)
q = deque([1])
visit[1] = True
while q:
    nextNode= q.popleft()
    for i in dic[nextNode]:
      if not visit[i]:
        visit[i] = True
        parent[i] = nextNode
        q.append(i)
for i in range(2, len(parent)):
  print( parent[i] )



            

      
      






























# from collections import deque

# n=int(input())
# graph={i:[] for i in range(1,n+1)}
# parents=[0]*(n+1)

# for i in range(n-1):
#   x,y = map(int, input().split())
#   graph[x].append(y) #연결시키기
#   graph[y].append(x)
# print(graph)
# queue=deque()
# queue.append(1)
# check = list(False for _ in range(n + 1))

# while queue:
#   temp = queue.popleft()
#   for i in graph[temp]:
#     if not check[i]: # 자식들을 계속 해주면 룹이 계속 돌아감 ㅋㅋ
#                 # 안됨 이미 지정되 있으니 다시 큐에 삽입하면 중복됨
#         parents[i] = temp # 자식들의 부모를 득록해줌 
#         check[i] = True 
#         queue.append(i)
# for i in parents[2:]:
#       print(i)

