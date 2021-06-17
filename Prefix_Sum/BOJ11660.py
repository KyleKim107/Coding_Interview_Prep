from sys import stdin


n, m = map(int, stdin.readline().split())

numbers = [[0] * (n + 1)]

for _ in range(n):
    nums = [0] + [int(x) for x in stdin.readline().split()]
    numbers.append(nums)

# prefix sum 행렬 만들기

# 행 별로 더하기
for i in range(1, n + 1):
    for j in range(1, n):
        numbers[i][j + 1] += numbers[i][j]
    print(numbers[i])

# 열 별로 더하기
for j in range(1, n + 1):
    for i in range(1, n):
        numbers[i + 1][j] += numbers[i][j]
    print(numbers[j])

for _ in range(m):
    x1, y1, x2, y2 = map(int, stdin.readline().split())
    print(numbers[x2][y2] - numbers[x1 - 1][y2] - numbers[x2][y1 - 1] + numbers[x1 - 1][y1 - 1]) 
         #마지마겡 더해주는건 numbers[x1 - 1][y2] 과 numbers[x2][y1 - 1]를 뺴주는 과정에서 numbers[x1 - 1][y1 - 1]를 두번 빼주기 때문임