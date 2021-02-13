import sys
input = sys.stdin.readline

N = int(input())
ans = {str(i): '' for i in range(1,201)}

for _ in range(N):
    age, name = input().split()
    ans[age] += f"{age} {name}\n"
print(ans)
for _, value in ans.items():
    # print((_,value))
    print(value, end='')

# import sys
# input = sys.stdin.readline

# N = int(input())
# ans = {str(i): '' for i in range(1,201)}
# for _ in range(N):
#     age, name = input().split()
#     ans[age] += f"{name}"

# # print(ans)
# for _, value in ans.items():
#     if value != '':
#         for _ in range()
#         print(int(_) ,end=' ')
#         print(value)
