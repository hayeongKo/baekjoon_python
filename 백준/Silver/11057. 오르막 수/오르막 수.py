# 11057
# 오르막 수

import sys

input = sys.stdin.readline

N = int(input())

dp = [[0]*10 for _ in range(N+1)]
dp[1] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

for i in range(N+1):
    dp[i][0] = 1

for i in range(2, N+1):
    for j in range(1, 10):
        dp[i][j] = dp[i][j-1] + dp[i-1][j]

print(dp[N][9] % 10007)
