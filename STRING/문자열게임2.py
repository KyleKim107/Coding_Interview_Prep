import sys

input =sys.stdin.readline

t = int(input())
for test_case in range(t):
    alphabet_cnt = {'a':0,'b':0,'c':0,'d':0,'e':0,'f':0,'g':0,'h':0,'i':0,'j':0,'k':0,
                    'l':0,'m':0,'n':0,'o':0,'p':0,'q':0,'r':0,'s':0,'t':0,'u':0,'v':0,
                    'w':0,'x':0,'y':0,'z':0}
    alphabet_idx = {'a':[],'b':[],'c':[],'d':[],'e':[],'f':[],'g':[],'h':[],'i':[],'j':[],'k':[],
                    'l':[],'m':[],'n':[],'o':[],'p':[],'q':[],'r':[],'s':[],'t':[],'u':[],'v':[],
                    'w':[],'x':[],'y':[],'z':[]}
    str_arr = input()
    k = int(input())

    min_length = 1e12
    max_length = -1
    cnt = 0

    for i in str_arr[:-1]:
        
        alphabet_idx[i].append(cnt)
        alphabet_cnt[i] += 1
        cnt += 1
    alphabet_candidate = ['a','b','c','d','e','f','g','h','i','j','k',
                    'l','m','n','o','p','q','r','s','t','u','v',
                    'w','x','y','z']
    for key,val in alphabet_cnt.items():
        if(val <k):
            alphabet_candidate.remove(key)


    print(alphabet_idx)
    if(len(alphabet_candidate)==0):
        print(-1)
    else:
        for i in alphabet_candidate:
            print('\ni', i ,'alphabet_idx[i]',alphabet_idx[i] )
            temp =0
            for j in range(0,len(alphabet_idx[i])-k+1):
                temp = alphabet_idx[i][j+k-1] - alphabet_idx[i][j] +1
                print(temp)
                if(temp>max_length and str_arr[alphabet_idx[i][j+k-1]]==str_arr[alphabet_idx[i][j]]):
                    max_length=temp
                if(temp<min_length):
                    min_length =temp

        print(min_length,max_length)


# import sys

# T = int(sys.stdin.readline())
# for _ in range(T):
#     minV = 1e9
#     maxV = -1e9
#     a = list( sys.stdin.readline().strip() )
#     num = int(sys.stdin.readline())
#     tmp = 0
#     for i in range(1,len(a) ):
#         for j in range(len(a)  ):
#             curr = a[j:j+i]
#             alpha = [0]*(26)
#             for j in range(len(curr)):
#                 if 'a' <= curr[j] <= 'z':
#                     alpha[ord(curr[j]) - ord('a')] += 1
#             if num in alpha:
#                 minV = min(sum(alpha) , minV)
#                 fe = []
#                 for i in range(len(alpha)):
#                     if alpha[i] == num:
#                         fe.append(chr(i + ord('a')))
#                 # print(fe)
#                 if curr[0] == curr[-1] and curr[0] in fe and curr[-1] in fe:
#                     print(curr)
#                     tmp = max(len(curr), maxV)
#     if minV == 1e9 :
#         print(-1)
#     else:
#         print(f'{minV} {tmp}')
            
        
        
        
        
        
        
        
            
# 2
# superaquatornado
# 2
# abcdefghijklmnopqrstuvwxyz
# 5