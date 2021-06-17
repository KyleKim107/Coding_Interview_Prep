N = int(input())
a =input()
b= list( a.strip().split('.'))
if N <= 25:
    print(a)
elif N > 25:
    remain = a[11:N-11]
    if remain[0] == '.' or remain[-1] == '.':
        front = a[:11]
        front += '...'
        front += a[N-11:]
        print(front)
    else:
        front = a[:9]
        front += '......'
        front += a[N-10:]
        print(front)



# 58
# IamInevitable.And,IamIronMan.IamInevitable.And,IamIronMan.