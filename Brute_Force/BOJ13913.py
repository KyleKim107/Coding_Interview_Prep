from collections import deque
def bfs(start, end): 
  dq, node2dist, node2head = deque([start]), {start : 0}, {}
  while dq :
    v = dq.popleft()
    for adj in [v + 1, v - 1, v * 2]:
      if adj not in node2dist and 0 <= adj <= 100000:
        node2head[adj] = v
        node2dist[adj] = node2dist[v] + 1
        dq.append(adj)
    if v == end:
      return node2head
start, end = map(int, input().split())
path = [end]
cur = end
node2head = bfs(start, end)

while cur != start:
  cur = node2head[cur]
  path.append(cur)

print(len(path) - 1)
print(*reversed(path))