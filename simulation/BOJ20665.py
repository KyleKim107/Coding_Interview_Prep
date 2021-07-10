n, t, p = map(int, input().split())
startEndDic = {}
allTimes = set([])
reservations = [list(map(int, input().split())) for _ in range(t)]
reservations.sort(key = lambda el: (el[0], el[1]-el[0]))

for s, e in reservations:
  allTimes.add(s)
  allTimes.add(e)
  if startEndDic.get(s) is not None:
    startEndDic[s].append(e)
  else: startEndDic[s] = [e]
    
# 시작시간과 끝시간이 포함 안될수도 있으니까 포함시켜주자
# 어차피 set이기 때문에 위에서 포함 되었어도 또 해도 상관없다. 중복은 알아서 제거됨
allTimes.add(900)
allTimes.add(2100)
allTimes = sorted(list(allTimes))
timeToIndex = {}
for idx, val in enumerate(allTimes): timeToIndex[val] = idx
timeTable = [[0]*n for _ in range(len(allTimes))]

def answer():
  global n, t, p, startEndDic, allTimes, reservations, timeTable, timeToIndex
  for i in range(len(timeTable)):
    s = allTimes[i]
    endTimes = startEndDic.get(s)
    if endTimes is None: continue
    for e in endTimes:
      endTimeIndex = timeToIndex[e]
      seatIndex = findSeatIndex(i)
      for j in range(i, endTimeIndex):
        timeTable[j][seatIndex] = 1
  result = 0
  for i in range(len(timeTable)-1):
    if timeTable[i][p-1] == 0:
      diff = timeDiff(allTimes[i], allTimes[i+1])
      result += diff
  return result

def findSeatIndex(timeIndex):
  global timeTable, timeToIndex
  seats = timeTable[timeIndex]
  seatIndex, maxDistance = 0, -1
  for i in range(len(seats)):
    # 이미 차있으면 볼일이 없다.
    if seats[i] == 1: continue
    
    downDistance = goDown(i, seats)
    upDistance = goUp(i, seats)
    
    d = min(downDistance, upDistance)
    if maxDistance < d:
      seatIndex, maxDistance = i, d;
  return seatIndex
      
def goDown(startIndex, seats):
  if startIndex == 0: return len(seats)
  distance = 0
  for i in range(startIndex-1, -1, -1):
    if seats[i] == 1: break
    distance += 1
  return distance
  
def goUp(startIndex, seats):
  if startIndex == len(seats)-1: return len(seats)
  distance = 0
  for i in range(startIndex+1, len(seats)):
    if seats[i] == 1: break
    distance += 1
  return distance
  
def getSeatNumbersWithOwner(startTime):
  global timeTable, timeToIndex
  arr = []
  ti = timeToIndex[startTime]
  for i in timeTable[ti]:
    if timeTable[ti][i] == 1: arr.append(i)
  return arr

def timeDiff(left, right):
  leftHour = left//100
  leftMinutes = left%100
  rightHour = right//100
  rightMinutes = right%100
  diffHour = rightHour - leftHour
  return rightMinutes - leftMinutes + diffHour * 60
  

print(answer())