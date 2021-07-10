N = int(input())
A = list(map(int, input().split()))
Q = int(input()) # 사람수
for _ in range(Q):
	a, b = map(int, input().split())
	if a == 1:
		for i in range(N):
			if (i + 1) % b == 0:
				A[i] ^= 1   # XOR
	else:
		b -= 1 # 차이 없애주기
		A[b] ^= 1 # 일단 그자리 없애줘
		for i in range(1, N):
			if b - i < 0 or b + i >= N: break # 만약 왼족이 범위 밖이라면 break  # 만약 오른쪽이 범위 밖이라면 break
			if A[b - i] == A[b + i]:
				A[b - i] ^= 1
				A[b + i] ^= 1
			else:
				break

for i in range((N - 1) // 20 + 1):
	print(*A[i * 20:(i + 1) * 20])