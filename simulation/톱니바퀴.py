import sys
from collections import deque

def Turning(gear,num, way):
    if way == 1:
        tmp =gear[num].pop()
        gear[num].appendleft( tmp)
    else:
        tmp = gear[num].popleft()
        gear[num].append(tmp)
    return gear


gear = []
gear.append([])
for _ in range(4):
    tmp = sys.stdin.readline().replace('\n','')
    geartmp = deque()
    for i in range(len(tmp)):
        geartmp.append(int(tmp[i]))
    gear.append(geartmp)

turn = int(sys.stdin.readline())
for _ in range(turn):
    gearNum, way = map(int, sys.stdin.readline().split())
    checkUP = []
    tmpWay = way
    for i in range(gearNum + 1, 5):
        if gear[i -1 ][2] != gear[i][6]:
            tmpWay = -tmpWay
            checkUP.append((i, tmpWay))
        else:
            break #안돌아 갈때
    
    tmpWay2 = way
    checkDown = []
    for i in range(gearNum - 1, 0, -1):
        if  gear[ i ][ 2 ] != gear[i +1][6]:
            tmpWay2 = -tmpWay2
            checkDown.append((i,tmpWay2))
        else:
            break #안돌아 갈때

    gear= Turning(gear, gearNum, way)
    for a,b in checkUP:
        gear = Turning(gear, a ,b)

    for a,b in checkDown:
        gear = Turning(gear, a ,b)
  
    

answer = 0
for i in range(1,5):
    if gear[i][0] == 1:
        answer += 2**(i-1)

print(answer)

