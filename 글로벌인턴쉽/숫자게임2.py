def combine(number , currTurn):
    STRnum = str(number)
    if len(STRnum) == 1:
        return currTurn
    elif len(STRnum) == 2:
        mul =int(STRnum[0]) * int(STRnum[1])
        ResultTurn =combine(mul , currTurn+1)
        return ResultTurn
    elif len(STRnum) == 3:
    
        a = combine(int(STRnum[2])*int(STRnum[1])*int(STRnum[0]), currTurn+1)
        b = combine(int(STRnum[0])*(int(STRnum[1])*10+int(STRnum[2])), currTurn+1)
        c = combine((int(STRnum[0])*10+int(STRnum[1]))*int(STRnum[2]), currTurn+1)
        
        return max([a,b,c])
    elif len(STRnum) == 4:
         
         
        a = combine((int(STRnum[0])*10+int(STRnum[1]))*(int(STRnum[2])*10+int(STRnum[3])), currTurn+1);
        b = combine(int(STRnum[0])*(int(STRnum[1])*100 + int(STRnum[2])*10 + int(STRnum[3])), currTurn+1);
        c = combine(int(STRnum[0])*int(STRnum[1])*(int(STRnum[2])*10 + int(STRnum[3])), currTurn+1);
        d = combine(int(STRnum[0])*(int(STRnum[1])*10+int(STRnum[2]))*int(STRnum[3]), currTurn+1);
        e = combine(int(STRnum[0])*int(STRnum[1])*int(STRnum[2])*int(STRnum[3]), currTurn+1);
        f = combine((int(STRnum[0])*100+int(STRnum[1])*10+int(STRnum[2]))*int(STRnum[3]), currTurn+1);
        g = combine((int(STRnum[0])*10+int(STRnum[1]))*int(STRnum[2])*int(STRnum[3]), currTurn+1);

        return max( [a,b,c,d,e,f,g] )
    elif len(STRnum) == 5:
        
        a = combine(int(STRnum[0])*int(STRnum[1])*int(STRnum[2])* (int(STRnum[3])*10+int(STRnum[4])), currTurn+1);
        b = combine(int(STRnum[0])*int(STRnum[1])* (int(STRnum[2])*100+int(STRnum[3])*10+int(STRnum[4])), currTurn+1);
        c = combine(int(STRnum[0])* (int(STRnum[1])*1000+int(STRnum[2])*100+int(STRnum[3])*10+int(STRnum[4])), currTurn+1);
        d = combine(int(STRnum[0])*int(STRnum[1])*int(STRnum[2])*int(STRnum[3])*int(STRnum[4]), currTurn+1);
        e = combine(int(STRnum[0])*int(STRnum[1])*(int(STRnum[2])*10+int(STRnum[3]))*int(STRnum[4]), currTurn+1);
        f = combine(int(STRnum[0])* (int(STRnum[1])*100+int(STRnum[2])*10+int(STRnum[3])) *int(STRnum[4]), currTurn+1);
        g = combine(int(STRnum[0])* (int(STRnum[1])*10+int(STRnum[2])) *int(STRnum[3])*int(STRnum[4]), currTurn+1);
        h = combine(int(STRnum[0])* (int(STRnum[1])*10+int(STRnum[2]))* (int(STRnum[3])*10+int(STRnum[4])), currTurn+1);
        i = combine((int(STRnum[0])*10+int(STRnum[1])) *(int(STRnum[2])*100+int(STRnum[3])*10+int(STRnum[4])), currTurn+1);
        j = combine((int(STRnum[0])*10+int(STRnum[1]))*(int(STRnum[2])*10+int(STRnum[3]))*int(STRnum[4]), currTurn+1);
        k = combine((int(STRnum[0])*10+int(STRnum[1]))*int(STRnum[2])*(int(STRnum[3])*10+int(STRnum[4])), currTurn+1);
        l = combine((int(STRnum[0])*100+int(STRnum[1])*10+int(STRnum[2]))*(int(STRnum[3])*10+int(STRnum[4])), currTurn+1);
        m = combine((int(STRnum[0])*1000+int(STRnum[1])*100+int(STRnum[2])*10+int(STRnum[3]))*int(STRnum[4]), currTurn+1);
        n = combine((int(STRnum[0])*100+int(STRnum[1])*10+int(STRnum[2]))*int(STRnum[3])*int(STRnum[4]), currTurn+1);
        o = combine((int(STRnum[0])*10+int(STRnum[1]))*int(STRnum[2])*int(STRnum[3])*int(STRnum[4]), currTurn+1);
        
        return max([a,b,c,d,e,f,g,h,i,j,k,l,m,n,o])

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    turn = 0
    n = int(input())
    answer= combine(n, turn)
    print('#%d %d' % (test_case, answer), end = '\n' )

    


