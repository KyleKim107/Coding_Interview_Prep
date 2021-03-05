import sys
I = sys.stdin.readline
N = int(I())
arr = list(map(int, I().split()))
arr.insert(0,999999999) # 처음건 가장 큰걸루 그래서 접근 가능하게
result = [0] * (N+1) # 취향것
stack = [0] # to adjust the indexes 
            #접근 가능한것들만 모아둬

for a in range(1,N+1): # 인덱스 1부터 시작 마지막 인덱스가 N+1
    while arr[stack[-1]] <= arr[a]:
        stack.pop()     # 스택에 있는 접근 불가능한 부분들을 제거해
    
    result[a] = stack[-1]# 스택에 있는 가장 접근 가능한 지점을 결과에 넣음
                        #결과에 먼저 넣어줘야해 왜냐하면 현재 'a'인덱스에서 접근 가능한곳을 가르키고 있어
    stack.append(a) # 그 다음 스택에 현재 지점 을 넣어

del result[0]
print(' '.join(map(str,result)))