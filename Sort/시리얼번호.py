from sys import stdin

N = int( stdin.readline() )
a=[]
for _ in range(N):
    cnt =0
    serial =stdin.readline()
    for ch in serial:
        if ch.isdigit():
            cnt += int(ch)
    a.append((serial.replace('\n',''),cnt))
a = sorted(a,key = lambda x: (len(x[0]),x[1],x[0]))
for i in range(len(a)):
    print(a[i][0])
    