# 1051
# 숫자 정사각형

import sys

input = sys.stdin.readline
N, M = map(int, input().split(" "))

square = []

for _ in range(N):
    temp = []
    nums = list(input().rstrip())
    for num in nums:
        temp.append(int(num))
    square.append(temp)

limit = N if N <= M else M
max = 1


for i in range(N):
    for j in range(M):
        for k in range(1, limit):
            if i+k < N and j+k < M: 
                if square[i][j] == square[i+k][j] == square[i][j+k] == square[i+k][j+k]:
                    if max < k+1:
                        max = k+1

print(max**2)