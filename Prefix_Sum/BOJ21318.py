import sys
input = sys.stdin.readline
N = int(input())
hard = list(map(int,input().split()))
s = [0] * N

for i in range(1, N):
    if hard[i-1] > hard[i]:
        s[i] = s[i-1] + 1 
    else:
        s[i] = s[i-1]
for _ in range(int(input())):
	x, y = map(int,input().split())
	print(s[y-1] - s[x-1])
