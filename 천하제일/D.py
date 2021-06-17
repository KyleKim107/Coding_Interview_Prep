from collections import deque
N = int(input())
nums= list(map(int, input().split()))
total = left = 0
res = len(nums) + 1
q = deque(nums)
for right in range(len(nums)):
    q.append(nums[right])
    a = abs(max(nums) - min(nums))
    while a <= 2:
        
# return res if res <= len(nums) else 0
    

# 14
# 1 2 3 4 2 5 7 1 2 3 4 2 5 7