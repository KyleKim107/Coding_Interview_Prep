import sys

def rotate_90(m):
    N = len(m)
    ret = [[0] * N for _ in range(N)]
    # 왜 'ret = [[0] * N] * N'과 같이 하지 않는지 헷갈리시면 연락주세요.
    # If we do not use list comprehensive, then the list will copy the reference of the element.

    for r in range(N): # row
        for c in range(N): # Col
            ret[c][(N-1)-r] = m[r][c]
    return ret
    # 회전 전의 열 번호와 회전 후의 행 번호가 일치한다. 
    # 그리고 회전 후의 열은 N-1 에서 회전 전의 행을 뺀 값과 같다.

def rotate(arr): #정사각형 외의 배열을 돌릴 수 있다 18808번 문제 푸는데 쓰임
    n,m = len(arr), len(arr[0])    # n = 2 m = 4
    dummy = list(list([0]*n) for _ in range(m))
    for i in range(m):
        for j in range(n):
            dummy[i][ n - 1 - j] = arr[j][i]

    return dummy



def rotate_180(m):
    N = len(m)
    ret = [[0] * N for _ in range(N)]

    for r in range(N):
        for c in range(N):
            ret[(N-1)-r][(N-1)-c] = m[r][c]
    return ret
    # 회전 후의 행 번호는 N-1 의 값에서 전의 행 번호를 뺀 것과 같다.
    # 회전 후의 열 번호는 N-1 의 값에서 전의 열 번호를 뺀 것과 같다.

def rotate_270(m):
    N = len(m)
    ret = [[0] * N for _ in range(N)]

    for r in range(N):
        for c in range(N):
            ret[(N-1)-c][r] = m[r][c]
    return ret



test = [[1,2,3], 
        [4,5,6],
         [7,8,9]]
test = rotate_90(test)
test = rotate_90(test)
test = rotate_90(test)
print(test)
# print(rotate_180(test))
#print(rotate_270(test))

[[9, 8, 7], [6, 5, 4], [3, 2, 1]] # 90 degree OH yeah!!    
[[7, 4, 1], [8, 5, 2], [9, 6, 3]] # 180 degree OH yeah!!
[[3, 6, 9], [2, 5, 8], [1, 4, 7]] # 270 degree OH yeah!!
