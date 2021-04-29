import sys


N = int(sys.stdin.readline())


def Dummy(n):
    game = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    k = int(sys.stdin.readline())
    snake = [[1, 1]]
    time = 0
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    c = []

    for i in range(k):
        x, y = map(int, sys.stdin.readline().split())
        game[x][y] = 1

    p = int(sys.stdin.readline())
    s = [0 for _ in range(p + 1)]

    for i in range(p):
        x, y = list(sys.stdin.readline().split())
        print((x,y))
        s[i] = x
        c.append(y)

    x = 1
    y = 1
    j = 0
    head = 0

    while snake:
        x = x + dx[head]
        y = y + dy[head]
        time += 1

        if [x, y] in snake or x < 1 or y < 1 or x > n or y > n:
            break

        if game[x][y] == 0:
            snake.append([x, y])
            del snake[0]
        elif game[x][y] == 1:
            snake.append([x, y])
            game[x][y] = 0

        if int(s[j]) == time:
            if c[j] == 'D':
                head += 1
            elif c[j] == 'L':
                head -= 1
            j += 1
            
        if head == 4 or head == -4:
            head = 0

    print(time)


Dummy(N)