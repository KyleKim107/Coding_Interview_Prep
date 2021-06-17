import re

result = re.findall(r"(<.*?>)|(\w+)|(\s)", input())
# "\w+": This expression matches the alphanumeric character in the string
#The '*', '+', and '?' qualifiers are all greedy; they match as much text as possible.
#  Sometimes this behaviour isn’t desired; if the RE <.*> is matched against '<a> b <c>',
#  it will match the entire string, and not just '<a>'. Adding ? after the qualifier makes
#  it perform the match in non-greedy or minimal fashion; as few characters as possible will 
# be matched. Using the RE <.*?> will match only '<a>'.
for tag, a, space in result:
    print((tag, a[::-1], space ))
    print(tag + a[::-1] + space, end="")
#<int><max>7463847412<long long><max>7085774586302733229

# import sys
# s, b = '', True
# for c in input():
#     if b:
#         if c == ' ' or c == '<':
#             sys.stdout.write(s[::-1] + c)
#             s = ''
#             if c == '<':
#                 b = False
#         else:
#             s += c
#     else:
#         sys.stdout.write(c)
#         if c == '>':
#             b = True
# sys.stdout.write(s[::-1])