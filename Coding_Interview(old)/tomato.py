import collections

def bfs(num, move):
    count = 0
    while True:
        size = len(move)
        if size == 0:
            break
        count += 1
        for _ in range(size):
            y, x = move.popleft()
            if x-1 >= 0: #left
                if num[y][x-1] == 0:
                    num[y][x-1] = 1
                    move.append([y, x-1])
            if x+1 < n: # Right
                if num[y][x+1] == 0:
                    num[y][x+1] = 1
                    move.append([y, x+1])
            if y+1 < m: # down
                if num[y+1][x] == 0:
                    num[y+1][x] = 1
                    move.append([y+1, x])
            if y-1 >= 0: # up
                if num[y-1][x] == 0:
                    num[y-1][x] = 1
                    move.append([y-1, x])
    return count

n, m = map(int, input().split())
num = []
move = collections.deque()
for i in range(m):
    line = []
    line = list(map(int, input().split()))
    num.append(line)
    size = len(line)
    for j in range(size):
        if line[j] == 1:
            move.append([i,j])

count = bfs(num, move)

for i in range(m):
    if 0 in num[i]:
        print(-1)
        break
    if i == m-1:
        print(count-1)

