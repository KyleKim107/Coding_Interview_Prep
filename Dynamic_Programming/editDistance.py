
A =input()
B =input()
a = list([0]*(len(B)+1) for _ in range(len(A)+1) )
for i in range(len(A)+1):
    a[i][0] = i
for i in range(len(B)+1):
    a[0][i] = i
print(a)
for i in range(1,len(A)+1):
    for j in range(1,len(B)+1):
        if A[i-1] == B[j-1]:
            a[i][j] = a[i-1][j-1]
        else:
            a[i][j] = min(a[i-1][j-1],a[i][j-1],a[i-1][j]) +1
print(a[len(A)][len(B)])
