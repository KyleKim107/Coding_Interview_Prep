import sys 
input()
l=[]
for i in map(int, sys.stdin):
    l.append(i) if i else l.pop()
print(sum(l))