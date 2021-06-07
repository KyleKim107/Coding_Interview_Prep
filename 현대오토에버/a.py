stk = []
a = b = c = 0
def solve(l):
    for s in l:  
        ans , stk = [],[]
        a = b = d = 0
        for c in s:
            if c == '[':
                if b != 0 or d != 0:
                    ans.append(0)
                    break
                stk.append(c)
                a += 1
            elif c == '{':
                if d != 0:
                    ans.append(0)
                    break
                stk.append(c)
                b += 1
            elif c == '(':
                stk.append(c)
                d += 1
            elif c == ']':
                if stk.pop() != '[':
                    ans.append(0)
                    break
            elif c == '{':
                if stk.pop() != '{':
                    ans.append(0)
                    break
            elif c == ')':
                if stk.pop() != '(':
                    ans.append(0)
                    break
        if len(stk) == 0 :
            ans.append(1)
        else:
            ans.append(0)
        print(ans)
    


print(solve(["{[]}()","({()})" , "s[(){{()}}]", "[()]()[{}]" ]))