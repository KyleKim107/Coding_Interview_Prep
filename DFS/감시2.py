# 선생님: T, 학생: S, 장애물: O
# 선생님 및 학생의 위치 정보가 주어졌을 때, 정확히 3개의 장애물을 설치하여 감시를 피할 수 있는지 여부 출력

# 데이터 입력받기
locations = set()
T = set()
n = int(input())
array = []
for i in range(n):
  temp = list(map(str, input().split()))
  array.append(temp)

for i in range(n):
  for j in range(n):
    if array[i][j] == 'X': locations.add((i,j))
    elif array[i][j] == 'T': T.add((i,j))

from itertools import combinations
comb = list(combinations(locations, 3))

# 상, 하, 좌, 우
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def check(T):
  for tx, ty in T:
    # 4방 검사
    for dir in range(4):
      nx, ny = tx +dx[dir], ty+dy[dir]
      while True:
        # 다음 위치가 범위 밖 or 장애물 이면
        if not(0<=nx<n and 0<=ny<n) or array[nx][ny] =='O': break
        if array[nx][ny] == 'S': 
          return False
        nx += dx[dir]
        ny += dy[dir]
  return True
  
def func(array, comb):
  global res
  for a, b, c in comb:
    # 장애물 설치하기
    array[a[0]][a[1]] = array[b[0]][b[1]] = array[c[0]][c[1]] = 'O'
    # 현재 장애물 조합에서 감시를 피한 경우 
    if check(T): 
      print("YES")
      return
    array[a[0]][a[1]] = array[b[0]][b[1]] = array[c[0]][c[1]] = 'X'
  print("NO")

# main
func(array, comb)