import sys


def rotate():
    x, y = 0, 0
    n, m = N, M
    time = min(N, M) // 2

    while time:
        print(time)
        cache = board[x][y]

        # 윗쪽
        for i in range(m - 1):
            board[x][y + i] = board[x][y + i + 1]
        
        # 오른쪽
        for i in range(n - 1):
            board[x + i][y + m - 1] = board[x + i + 1][y + m - 1]

        # 아래쪽
        for i in range(m - 1):
            board[x + n - 1][y + m - 1 - i] = board[x + n - 1][y + m - 2 - i]

        # 왼쪽
        for i in range(n - 1):
            board[x + n - 1 - i][y] = board[x + n - 2 - i][y]
        board[x + 1][y] = cache

        n -= 2 # -2인 이유는 시계 반대방향으로 하나씩 땡겨서 하기 떄문, 
        m -= 2
        x += 1
        y += 1
        time -= 1


def solution():
    for _ in range(R):
        rotate()

    for row in board:
        print(*row)


if __name__ == '__main__':
    N, M, R = list(map(int, sys.stdin.readline().split()))
    board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

    solution()