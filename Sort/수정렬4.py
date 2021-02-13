import sys
n = int(sys.stdin.readline())
a = sorted(list(map(int,sys.stdin.read().split())),reverse=True)
print('\n'.join(map(str,a)))