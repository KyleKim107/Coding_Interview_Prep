def solution(s):
    answer = len(s)
    if answer == 0:
        return 0

    minVal = len(s)
    for tic in range(1,len(s)//2+1):
        prev = s[0:tic]
        cnt = 1
        comp = ''
        for i in range(tic,len(s), tic):
            #print(s[i: tic+i])
            if prev == s[i: tic+i]:
                cnt += 1
            else:
                comp += str(cnt) + prev if cnt > 1 else prev
                prev = s[i:tic+i]
                cnt = 1
        comp += str(cnt) + prev if cnt > 1 else prev
        
        #print(comp)
        minVal = min(minVal,len(comp))

    answer = minVal
    return answer

print(solution("xababcdcdababcdcd"))