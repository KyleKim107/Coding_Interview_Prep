
def StringNMulti(left , right):
    # print((left,right))
    st1, st2 = '',''
    for num in left:
        st1 += num
    # print(st1)
    for num in right:
        st2 += num
    # print(st2)
    return int(st1) * int(st2)

turn = -1e9
def BF(arr , currTurn):
    global turn
    if len(arr) == 1 :
        # print(arr)
        turn = max(currTurn, turn)
        return
    # elif :
    
    for i in range(1,len(arr)):
        # print
        left = arr[:i]
        right = arr[i:]
        # print((left,right))
        cnt = 1
        multiedValue = StringNMulti(left,right)
        # print((left,right))
        nextArr =list(str(multiedValue))
        BF(nextArr , currTurn +1)
    if len(arr) > 1: #recursion completed ARR
        num = 1
        # print(arr)
        for i in arr:
            num *= int(i)
        BF(list(str(num)) , currTurn +1)
    return


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    numList = list(input())
    if len(numList) == 1:
    	 turn =0
    else: 
    	BF(numList, 0)
    print('#%d %d' % (test_case, turn), end = '\n' )

    
