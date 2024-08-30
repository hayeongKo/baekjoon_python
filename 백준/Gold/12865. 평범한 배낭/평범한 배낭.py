# 12865
# 평범한 배낭

import sys

items = [[0, 0]]
input = sys.stdin.readline

N, K = map(int, input().split())

dp = [[0] * (K+1) for _ in range(N+1)]

for _ in range(N):
    items.append(list(map(int, input().split())))

for i in range(1, N+1): # item index
    for j in range(1, K+1):  # weight
        W = items[i][0]
        V = items[i][1]

        if j < W:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-W]+V)

print(dp[N][K])
