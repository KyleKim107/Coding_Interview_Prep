import sys

def turnN(key):
    newKey = [[0]*len(key) for _ in range(len(key))]
    N = len(key)
    for i in range(N):
        for j in range(N):
            newKey[j][(N-1)-i] = key[i][j]
    return newKey
    # print(newKey)

def check(lock,newLock):
    size = len(newLock)
    for i in range(len(lock), size - len(lock)):
        for j in range(len(lock), size- len(lock)):
            if newLock[i][j] != 1:
                return False
    return True
                
    
def solution(key, lock):
    newLock = [[0]*(len(lock)*3) for _ in range(len(lock)*3)]
    n = len(lock)
    m = len(key)
    size = len(newLock)
    for i in range(n):
        for j in range(n):
            newLock[i+n][j+n] = lock[i][j]
    
    for rotation in range(4):
        key = turnN(key)
        for i in range(len(lock)*2):
            for j in range(len(lock)*2):
                print((i,j))
                for k in range(len(key)):
                    for l in range(len(key)):
                        newLock[i+k][j+l] += key[k][l]            
                
                if check(lock,newLock) == True:
                    return True
                for k in range(len(key)):
                    for l in range(len(key)):
                        newLock[i+k][j+l] -= key[k][l]
            
    answer = False
    return answer
