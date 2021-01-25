import sys

a = list(input())
a.sort()
num = 0
while True:
    if a[0].isnumeric(): # isalpha could be used
        tmp = a.pop(0)
        num += int(tmp)
    else:
        break
if num != 0:
    a.append(str(num))
print(''.join(a))


# K1KA5CB7
# AJKDLSI412K4JSJ9D