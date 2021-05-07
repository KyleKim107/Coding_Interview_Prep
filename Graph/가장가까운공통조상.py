import sys
T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    par = [0]*(N+1)
    for _ in range(N -1):
        A,B = map(int, sys.stdin.readline().split())
        par[B] = A
    A,B = map(int, sys.stdin.readline().split())
    Apar, Bpar = [A],[B]

    while par[A]:
        Apar.append(par[A])
        A =par[A]

    while par[B]:
        Bpar.append(par[B])
        B =par[B]
    
    lenA = len(Apar) - 1
    lenB = len(Bpar) -1
    while lenA >= 0 and lenB >= 0 and Apar[lenA] == Bpar[lenB]:
        lenA -= 1
        lenB -= 1
    print(Apar[lenA + 1 ])







# import sys
# T=int(sys.stdin.readline())
# for _ in range(T):
#     N=int(sys.stdin.readline())
#     p_list=[0 for _ in range(N+1)]#각 노드의 부모노드 저장
#     for _ in range(N-1):
#         p,c=map(int,sys.stdin.readline().split())
#         p_list[c]=p#부모 노드 저장
 
#     print(p_list)
#     a,b=map(int,sys.stdin.readline().split())
#     a_parent=[a]
#     b_parent=[b]
#     #각노드의 부모노드가 루트일때까지 모두 저장
#     while p_list[a]:
#         a_parent.append(p_list[a])
#         a=p_list[a]
 
#     while p_list[b]:
#         b_parent.append(p_list[b])
#         b=p_list[b]
 
#     #같은 레벨로 맞추고 부모노드 같은거 찾기
 
 
#     a_level=len(a_parent)-1
#     b_level=len(b_parent)-1
#     # 루트노드부터 차례대로 비교 , 루트가 가장 마지막에 갑입되었다. 
#     while a_parent[a_level]==b_parent[b_level]:#부모노드가 같지 않을때까지
#         a_level-=1
#         b_level-=1
 
#     print(a_parent[a_level+1])


# # import sys

# # def find(par, x):
# #     if par[x] != x:
# #         x = find(par, par[x])
# #     return x

# # def union(par, A,B):
# #     A = find(par, A)
# #     B = find(par, B)
# #     par[B] = A

# # T = int(sys.stdin.readline())
# # for _ in range(T):
# #     N = int(sys.stdin.readline())
# #     par = [0]*(N+1)
# #     for i in range(len(par)):
# #         par[i] = i
    
# #     for i in range(N):
# #         A,B = map(int, sys.stdin.readline().split())
# #         if i == (N-1):
# #             for i in range(len(par)):
# #                print(f'find(par,i) {find(par,i)}')
# #             print(par)

# #         union(par, A,B)



