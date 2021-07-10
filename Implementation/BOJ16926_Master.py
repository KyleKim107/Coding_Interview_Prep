from collections import deque
N,M,R = map(int, input().split())
a = list( list( map(int, input().split())) for _ in range( N))
# print(a)

def rotation(x,y,w,h):
    q = deque()
    for i in range(x, x+w): # 가로 너비를 구해야해 x+width까지하면 해당 뎁스의 가로 너비가 나옴 
        q.append(a[x][i]) #  i 는 렬만 짚어주고 x는 아직 0
    for i in range( y + 1 , y+ h): # y+h가 행을 끝까지 가게 해줘
        q.append(a[i][x+w-1]) # i는 행만 짚어주고 그 뎁스의 너비의 마지막 즉 끝의 element를 짚어 줘야 하니까 x+w -1
    for i in range(x+w-2 , x ,-1):#  밑에부터 x+w-2가 가장 아래끝에서 두번째 요소부터 시작해. #중요# 여기서는 밑줄 양끝을 제외한 element들만 처리함
                                # for i in range(?,?-1)같이 룹이 마이너스 형식으로 갈땐 실제 그값을 넣어줘야 해서 -2
        q.append(a[y+h-1][i])   # 현제 댑스의 마지막 즉, h+y-1을 사용해 행을 고르고 i로 렬을 고른다
    for i in range(y+h -1 , y , -1): # 왼쪽을 처리해 주기위해 y+h-1, 
        q.append(a[i][y]) # y값으로 현제 댑스의 열을 골라주고, i로 행을 골라줘 
    q.rotate(-R)
    for i in range(x, x+w):
        a[x][i] = q.popleft()
    for i in range( y + 1 , y+ h): #오른
        a[i][x+w-1] = q.popleft()
    for i in range(x+w-2 , x ,-1):
        a[y+h-1][i] =q.popleft()
    for i in range(y+h -1 , y , -1):
        a[i][y] = q.popleft()


x,y = 0,0
w,h = M,N
while True:
    if w == 0 or h == 0:
        break
    rotation(x,y,w,h)
    x += 1
    y += 1
    w -= 2
    h -=2
for line in a:
    for i in range(len(line)):
        print(line[i], end = ' ')
    print()

