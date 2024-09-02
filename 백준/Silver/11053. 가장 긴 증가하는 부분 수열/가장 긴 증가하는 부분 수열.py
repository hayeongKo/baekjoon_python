# 11053
# 가장 긴 증가하는 부분 수열

import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
dp = [0 for _ in range(N)]

for i in range(N): # 현재 수
    for j in range(i): # 이전 수 방문
        if nums[i] > nums[j] and dp[i] < dp[j]: # 현재 값이 이전수보다 크고, dp 값이 이전 값이 더 클 경우 가져옴
            dp[i] = dp[j]
    dp[i] += 1
print(max(dp))