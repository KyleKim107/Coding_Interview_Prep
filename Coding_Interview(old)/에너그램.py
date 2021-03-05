import sys

a = sys.stdin.readline().strip()
b = sys.stdin.readline().strip()
stat1 = [0 for i in range(27)]
stat2 = [0 for i in range(27)]
for i in range(len(a)):
    stat1[ord(a[i])-97] += 1
# print(stat1)
for i in range(len(b)):
    stat2[ord(b[i])-97] += 1
# print(stat2)
stat3 = [abs(stat1[k]-stat2[k]) for k in range(len(stat1)) if stat1[k] != stat2[k]] 
print(sum(stat3))
    

# asdffg
# asdf