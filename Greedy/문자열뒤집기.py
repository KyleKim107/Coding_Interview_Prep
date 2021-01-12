a = list(map(int, input()))
zero1= 0
one1 = 0
if a[0] == 1:
    one1 += 1
else:
    zero1 += 1
for i in range(len(a)-1):
    if a[i] != a[i+1]:
        if a[i+1] == 1:
            one1 += 1
        else:
            zero1 += 1
res  = min(one1 , zero1)
print(res)

