def find_arr(arr):
    global result
    for bit_mask in range(2**8):
        copy_arr = [row[:] for row in arr]
        change_bit = str(bin(bit_mask))[2:].count('1')
        if result < change_bit:
            continue
        for row in range(3):
            if bit_mask & (1<<row):
                for col in range(3):
                    copy_arr[row][col] = (copy_arr[row][col]+1)%2

        for col in range(3):
            if bit_mask & (1<<(col+3)):
                for row in range(3):
                    copy_arr[row][col] = (copy_arr[row][col]+1)%2


        if bit_mask & (1<<6):
            for row in range(3):
                copy_arr[row][row] = (copy_arr[row][row]+1)%2

        if bit_mask & (1<<7):
            for row in range(3):
                copy_arr[row][2-row] = (copy_arr[row][2-row]+1)%2

        sum_temp = sum(list(map(sum,copy_arr)))
        if sum_temp == 9 or sum_temp == 0:
            result = change_bit


T = int(input())



for tc in range(T):
    arr = []
    result = float('inf')
    for _ in range(3):
        s = list(input().split())
        for i in range(3):
            if s[i] == 'T':
                s[i] = 1
            else:
                s[i] = 0
        arr.append(s)
    
    cnt = 0

    find_arr(arr)
    print(-1 if result == float('inf') else result)