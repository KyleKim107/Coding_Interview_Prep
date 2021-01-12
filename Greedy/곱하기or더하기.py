import sys
a = list(map(int, input()))
if a[0] == 0: 
    ans = 0
else:
    ans = a[0]
for i in range(len(a)-1):
    
    if a[i+1] == 0 or a[i+1] == 1 :
        ans += a[i+1]
    else:
        ans *= a[i+1]
    
    
print(ans)