import sys

if __name__ == "__main__":
    n, c = map(int, sys.stdin.readline().split())
    m = int(sys.stdin.readline())
    box = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]


    box.sort(key=lambda x:x[1])  # 도착 시간이 빠른 순서로 정렬
    for line in box:
        print(line)
    answer = 0  # 최대 박스 수
    remain = [c] * (n + 1)  # 각 위치에 남은 공간
    for i in range(m):
        temp = c  # c개를 옮길 수 있다고 가정
        for j in range(box[i][0], box[i][1]):
            print(j)
            temp = min(temp, remain[j])
        temp = min(temp, box[i][2]) # 10
        for j in range(box[i][0], box[i][1]):
            remain[j] -= temp
        print(remain)
        answer += temp
    print(answer)

import sys 

# N, capa = map(int, sys.stdin.readline().split())
# num = int(sys.stdin.readline())
# pacle = sorted( list(list(map(int, sys.stdin.readline().split())) for _ in range(num)) , key = lambda x: x[0])
# # for line in pacle:
# #     print(line)
# dic = {}
# cnt , left = 0 ,0

# for i in range(1,N+1):
#     #화물 내리기
#     if i > 1 and i in dic and dic[i] != 0:
#         cnt += dic[i]
#         left -= dic[i]
#         dic[i] = 0

#     for j in range(len(pacle)): # 화물 수집
#         if pacle[j][0] == i:
#             if left + pacle[j][2] <= capa:
#                 left += pacle[j][2]
#                 if pacle[j][1] in dic:
#                     dic[pacle[j][1]] += pacle[j][2] 
#                 else:
#                     dic[pacle[j][1]] = pacle[j][2]
#             else:
#                 l = capa - left
#                 if pacle[j][2] >= l:
#                     left += l
#                     if pacle[j][1] in dic:
#                         dic[pacle[j][1]] += l
#                     else:
#                         dic[pacle[j][1]] = l
# print(cnt)
    

# # 3 15
# # 2
# # 1 2 3
# # 2 3 8

