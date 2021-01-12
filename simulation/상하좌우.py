n = int(input())
a = list(input().split())
human = (0,0)
for i in range(len(a)):
    x,y = human
    if a[i] == "R":
        if (y + 1) >= n-1:
            continue
        y += 1
    elif a[i] =="L":
        if y - 1 < 0:
            continue
        y -= 1
    elif a[i] =="U":
        if x - 1 < 0:
            continue
        x -= 1
    elif a[i] =="D":
        if (x + 1) >= n-1:
            continue
        x += 1
    human = (x , y)
x, y  = human
print((x+1, y+1))
