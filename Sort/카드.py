import sys
N = int(sys.stdin.readline())
dic = {}
for _ in range(N):
    num = int(sys.stdin.readline())
    dic[num] = dic.get(num,0)+1
# print(dic)
dic= sorted(dic.items(), key=lambda x: (-x[0]))
print(dic[0][0])
