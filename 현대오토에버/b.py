from collections import deque
def solve(li):
  dq, node2dist = deque([(0, 0)]), {0: 0}
  N = len(li) - 1
  while dq:
    u, dist = dq.popleft()
    print(u, dist, node2dist)
    if u == N:
      return node2dist[u]
    for v in (u + 1, u + 2, u + 3, u + 4, u + 5, u + 6):
      v = min(v, N)
      while li[v] != 0:
        node2dist[v] = dist
        v = max(0, min(v + li[v], N))
      if v not in node2dist:
        node2dist[v] = dist + 1
        dq.append((v, dist + 1))

tc1 = [0, 0, 0, 0, 0, 0, 0, 0, 0]
re1 = solve(tc1)
assert re1 == 2, f"{re1}"
print(("TC1",re1 == 2))
tc2 = [0, 3, 0, -2, 8, -2, 0, -2, 0]
re2 = solve(tc2)
assert re2 == 1, f"{re2}"
print(("TC2",re2 == 1))
tc3 = [0, -9, -9, -9, 0, -9, -9, 10, -2, -1, -1, -1, -1, -1, 0, -2, -2, -1, -1, -1, -0]
re3 = solve(tc3)

assert re3 == 3, f"{re3}"
print(("TC1",re3 == 3))