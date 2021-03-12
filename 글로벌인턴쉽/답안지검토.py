import sys 

testNum = int(input())
for numCase in range(testNum):
    students , problems = map(int, sys.stdin.readline().split())
    answer = list(map(int, sys.stdin.readline().split()))
    studentsAns = list( list( map( int, sys.stdin.readline().split())) for _ in range(students) )
    
    maxScore, minScore = -1e9,1e9
    for Sheet in studentsAns:
        cnt, score = 0, 1
        for i in range(len(Sheet)):
            if answer[i] == Sheet[i]:
                cnt += score
                score += 1
            else:
                score = 1
        maxScore = max(maxScore, cnt)
        minScore = min(minScore, cnt)
    print('#%d %d' % (numCase +1, maxScore - minScore) )
    

