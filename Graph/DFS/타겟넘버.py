answer = 0
def DFS(idx, numbers, target, value):
    print(value)
    global answer
    N = len(numbers)
    if(idx== N and target == value):
        answer += 1
        return
    if(idx == N):
        return

    DFS(idx+1,numbers,target,value+numbers[idx])
    DFS(idx+1,numbers,target,value-numbers[idx])

def solution(numbers, target):
    global answer
    DFS(0,numbers,target,0)
    return answer