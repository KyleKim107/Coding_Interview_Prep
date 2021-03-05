import sys
N = int(sys.stdin.readline())
ls = list( int(i) for i in sys.stdin.readline().split())
result = [0]* (N+1)
stack= [0]
ls.insert(0, 99999999)
for i in range(1, N+1):
    while ls[stack[-1]] <= ls[i]:
        stack.pop()
    result[i] = stack[-1] 
    stack.append(i)
del result[0]
print(' '.join(map(str,result)))

    

    

