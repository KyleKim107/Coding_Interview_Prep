def solution(n, computers):
    answer = 0
    bfs = []
    visited = [0]*n
    while 0 in visited:
        bfs.append(visited.index(0))
        while bfs:
            num = bfs.pop(0)
            visited[num] = 1
            for i in range(n):
                if visited[i] == 0 and computers[num][i] == 1: # visited[i] == 0 -> 반복을 피하기 
                    # computers[num][i] == 1 현재 컴퓨터랑 연결되어 있어야함
                    bfs.append(i)
        answer += 1
    return answer