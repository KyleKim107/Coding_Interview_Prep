N = int(input())
d = [0]*1001
d[1] = 1
d[2] = 3 
for i in range(3,len(d)):
    d[i] = d[i-2]*2 + d[i-1]
print(d[N])