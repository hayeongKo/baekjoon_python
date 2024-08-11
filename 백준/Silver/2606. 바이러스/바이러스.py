# 2606
# 바이러스

import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
V = int(input())

graph = [[] for _ in range(N+1)]

for i in range(V):
    a, b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N+1)
cnt = -1

def dfs(v):
    visited[v] = True
    global cnt
    cnt += 1

    for i in graph[v]:
        if not visited[i]:
            dfs(i)

dfs(1)
print(cnt)