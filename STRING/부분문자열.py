def make_table(pattern):
    length = len(pattern)
    table = [0] * length
    j = 0

    for i in range(1, length):
        while j > 0 and pattern[i] != pattern[j]:
            j = table[j - 1]
            
        if pattern[i] == pattern[j]:
            j += 1
            table[i] = j
    print(table)
    return table


def kmp(parent, pattern):
    table = make_table(pattern)
    parent_length = len(parent)
    pattern_length = len(pattern)

    j = 0
    for i in range(parent_length):
        while j > 0 and parent[i] != pattern[j]:
            j = table[j - 1]

        if parent[i] == pattern[j]:
            if j == pattern_length - 1:
                return 1
            else:
                j += 1

    return 0


parent = input()
pattern = input()
print(kmp(parent, pattern))
    

