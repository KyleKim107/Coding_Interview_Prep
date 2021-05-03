import sys
import heapq
input = sys.stdin.readline 
n = int(input().rstrip()) 
q = [] 
for _ in range(n): 
    q.extend(list(map(int, input().rstrip().split(" ")))) 
    q = heapq.nlargest(n, q) #메모리 줄이려고 계속 걸러 주는건가?
print(q[-1])

