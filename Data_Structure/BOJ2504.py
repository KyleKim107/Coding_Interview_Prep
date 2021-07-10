def f(p):
    if len(p) == 0 : return 1
    dic = {'(':')', '[':']'}
    val, sub, stk = 0, '', []
    #(()[[]])([])
    for i in p :
        sub += i
        # print(stk)
        if len(stk) > 0 and dic.get(stk[-1], '') == i :# print('stk[-1]',stk[-1],'dic.get(stk[-1], '')','=',dic.get(stk[-1], ''),'i',i)
                                                        # 스택 길이가 0이 아니고, 현재값이 스택의 마지막 괄호와 짝인것을 리턴
            stk.pop()
        else :
            stk.append(i)

        if len(stk) == 0 : # 한분절이 끝날때마다 계산
            val += f(sub[1:-1]) * (2 if sub[0] == '(' else 3)
            sub = ''

    if len(stk) > 0 : #유효하지 못한 문자열
        return 0
    return val

print(f(input()))