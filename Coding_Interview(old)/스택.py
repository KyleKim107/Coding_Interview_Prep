import sys 

n = int(sys.stdin.readline())
stack = []
for _ in range(n):
    cmd = sys.stdin.readline().split()
    
    if cmd[0] == "push" :
        stack.append(cmd[1])

    elif cmd[0] == "pop":
        try:
            stack.pop()
        except:
            print("-1")
        print(stack[num-1])

    elif cmd[0] == "size":
        print(len(stack))

    elif cmd[0]== "empty":   
        if len(stack) > 0:
            print(0)
            continue
        stack = []
        print(1)

    elif cmd[0]== "top":
        if len(stack) == 0:
            print("-1")
            continue
        num = len(stack)
        print(stack[num-1])            

    
    

    
