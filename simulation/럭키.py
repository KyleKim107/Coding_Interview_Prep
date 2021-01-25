import sys 

a = list(map(int, input()))
l = len(a)
left = 0
right  = 0

for i in range( int(l /2) ):
    print(i)
    left += a[i]

for i in range(int(l /2) , l):
    print(i)
    right += a[i]

if left == right:
    print("LUCKY")
else:
    print("READY")


    
