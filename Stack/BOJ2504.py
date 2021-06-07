def _2504():
    Stack = []
    N = str(input())

    cur = 1
    res = 0

    for i in range(len(N)):
        
        if N[i] == ']' or N[i] ==')':
            if not Stack:
                print(0)
                return
            
        if N[i] == '(':
            Stack.append('(')
            cur = cur * 2
            if i + 1 < len(N) and N[i+1] == ')': # 길이체크, 닫히는거면 결과에 더해줘
                # print(cur)
                res += cur

        elif N[i] == '[':
            Stack.append('[')
            cur = cur * 3
            if i + 1 < len(N) and N[i+1] == ']':
                res += cur

        if Stack:
            if N[i] == ')':
                cur = cur // 2
                if Stack[-1] == '(':
                    Stack.pop()
            elif N[i] == ']':
                cur = cur // 3
                if Stack[-1] == '[':
                    Stack.pop()
        print('curr' , N[i], 'stack', Stack, 'curr', cur, 'result', res)


    if Stack:
        print(0)
        return 0

    print(res)
_2504()