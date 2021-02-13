from sys import stdin
N = int(stdin.readline().rstrip())
a= list(map(int,stdin.readline().split()))
M = int(stdin.readline().rstrip())
b= list(map(int,stdin.readline().split()))
# for ch in b:
#     if ch in a:
#         print('yes')
#     else:
#         print('no')

def BST(array, tar, start, end):
    if start > end:
        return None
    mid = (start+ end)//2
    if array[mid] == tar:
        return mid
    
    if array[mid] < tar:
        return BST(array , tar, mid+1, end)
    else:
        return BST(array , tar, 0, mid-1)



for ch in b:
    result = BST(a, ch , 0, len(a)-1)
    if result == None:
        print('no')
    else:
        print('yes')
    
