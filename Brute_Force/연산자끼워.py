

import sys
def BF(currIndex , num , totalNUM, plus, minus, mul, div ):
    global maxV, minV
    if currIndex == DUM-1:
        maxV = max(totalNUM, maxV)  
        minV = min(totalNUM, minV)        
    else:
        if plus > 0:
            BF(currIndex + 1, num , totalNUM + num[ currIndex + 1 ] , plus -1 , minus, mul, div  )
            # print(st)
        if minus > 0:
            BF(currIndex + 1, num , totalNUM - num[ currIndex + 1 ] , plus  , minus -1, mul, div   )
            # print(st)
        if mul > 0:
            BF(currIndex + 1, num , totalNUM * num[ currIndex + 1 ] , plus , minus, mul-1, div)
            # print(st)
        if div > 0:
            if totalNUM < 0:
                totalNUM= -totalNUM // num[ currIndex + 1 ]
                BF(currIndex + 1, num , -totalNUM , plus , minus, mul, div -1)
            else:
                BF(currIndex + 1, num , totalNUM // num[ currIndex + 1 ] , plus , minus, mul, div -1)


maxV = -1e9
minV = 1e9
DUM = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))
plus, minus, mul, div = map(int, sys.stdin.readline().split())


BF(0 , num , num[0],plus, minus, mul, div )
print(maxV)
print(minV)


  # else:
       
        # if turn ==1:
        #     BF(currIndex + 1, num , totalNUM - num[ currIndex + 1 ] , plus  , minus -1, mul, div ,st+'-'+str(num[ currIndex + 1 ]) ,turn+1  )
        #     print((st+'-'+str(num[ currIndex + 1 ]), totalNUM - num[ currIndex + 1 ]))
        # if turn == 2:
        #     if totalNUM < 0:
        #         totalNUM=-totalNUM // num[ currIndex + 1 ]
                
        #     BF(currIndex + 1, num , -totalNUM , plus , minus, mul, div -1, st+'%'+str(num[ currIndex + 1 ]) ,turn+1)
        #     print((st+'%'+str(num[ currIndex + 1 ]), totalNUM // num[ currIndex + 1 ]))
        # if turn == 3:
        #     BF(currIndex + 1, num , totalNUM + num[ currIndex + 1 ] , plus -1 , minus, mul, div  ,st+'+'+str(num[ currIndex + 1 ])  ,turn+1)
        #     print((st+'+'+str(num[ currIndex + 1 ]), totalNUM + num[ currIndex + 1 ] ))
        # if turn == 4:
        #     BF(currIndex + 1, num , totalNUM + num[ currIndex + 1 ] , plus -1 , minus, mul, div  ,st+'+'+str(num[ currIndex + 1 ])  ,turn+1)
        #     print((st+'+'+str(num[ currIndex + 1 ]), totalNUM + num[ currIndex + 1 ]))
        # # print(st)
        # if turn ==5:
        #     BF(currIndex + 1, num , totalNUM * num[ currIndex + 1 ] , plus , minus, mul -1, div  ,st+'*'+str(num[ currIndex + 1 ]) ,turn+1 )
        #     print((st+'*'+str(num[ currIndex + 1 ]), totalNUM * num[ currIndex + 1 ]))
        #     # print(st)