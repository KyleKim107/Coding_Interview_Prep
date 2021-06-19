x,a,y,b=eval('input().split(),'*4)
a={*a}
print(a)
print(b)
for i in b:
    print( +(i in a) )


# N = int(input())
# a = sorted(list(map(int, input().split())))
# M = int(input())

# def binarySearch(arr ,start ,end ,num):
#     if start > end:
#         return 

#     mid = (start + end)//2
#     if arr[mid] == num:
#         return True
#     elif arr[mid] > num:
#         return binarySearch(arr,start ,mid -1 ,num)
#     else:
#         return binarySearch(arr, mid+1 ,end ,num)
    

# for num in list(map(int, input().split())):
#     if binarySearch(a, 0,len(a)-1,num):
#         print(1)
#     else:
#         print(0)


