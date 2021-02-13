def solution(N, stages):
    stages.sort()
    ans = []
    leng = len(stages)
    for i in range(1,N+1):
        cnt = stages.count(i)
        if cnt == 0:
            fail = 0
            # fail = cnt / leng
            print(fail)
        else:
            fail = cnt / leng
        ans.append((i, fail))
        leng -= cnt
    ans.sort(key = lambda x: (-x[1],x[0]))
    answer = []
    for line in ans:
        answer.append(line[0])

    return answer


print(solution( 4 , [4,4,4,4,4]))