import sys
from collections import defaultdict

N = int(sys.stdin.readline())
ls = set()
dic = defaultdict(int)

for _ in range(N):
    name , extention  = sys.stdin.readline().rstrip().split('.')
    ls.add(extention)
    dic[extention] += 1
ls = list(ls)
ls.sort()
for file in ls:
    print(f'{file} {dic[file]}')




# a = list( list( map(str , sys.stdin.readline().replace('\n',''))) for _ in range(N))
# dic, ls = dict(), []

# for file in a:
#     for i in range(len(file) -1 , -1, -1):
#         if file[i] == '.':
#             st = ''
#             for j in range(i +1 , len(file)):
#                 st += file[j]
#             ls.append(st)
#             if st in dic:
#                 dic[st] += 1
#             else:
#                 dic[st] = 1
#             break
# ls = set(ls)
# ls = sorted(list(ls))
# for tail in ls:
#     print(tail , dic[tail])     
                



            