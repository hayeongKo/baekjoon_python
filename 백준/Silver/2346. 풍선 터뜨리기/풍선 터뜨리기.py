from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
result = list(map(int, input().split()))
nums = deque()

for i in range(1, n+1):
    nums.append([i, result[i-1]])

for i in range(n):
    x = nums.popleft()
    print(x[0])
    nums.rotate(-x[1]+1 if x[1] > 0 else -x[1])