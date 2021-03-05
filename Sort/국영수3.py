import sys
a = int(sys.stdin.readline())
l = []
for i in range(a):
    name, lit, en, math = sys.stdin.readline().split()
    l.append((name, int(lit), int(en), int(math)))
l = sorted(l , key = lambda x:(-x[1],x[2], -x[3], x[0]) )
for student in l:
    print(student[0])

    
