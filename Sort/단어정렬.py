import sys
N = int(sys.stdin.readline())
a=set()
for _ in range(N):
    a.add(sys.stdin.readline().rstrip())
a = sorted(list(a), key = lambda x:(len(x),x) )
print('\n'.join(a))

# import sys
# word=set()
# for i in range(int(input())):
#     word.add(sys.stdin.readline().rstrip())
# word=list(word)
# word.sort()
# word.sort(key=lambda x:len(x))
# print("\n".join(word))
