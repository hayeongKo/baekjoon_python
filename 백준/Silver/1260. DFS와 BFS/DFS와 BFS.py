# 1260
# DFS와 BFS

from collections import deque

N, M, V = map(int, input().split(" "))

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)

visited_bfs = [False] * (N+1)
visited_dfs = [False] * (N+1)

def dfs(start):
    visited_dfs[start] = True
    print(start, end=" ")

    for i in graph[start]:
        if not visited_dfs[i]:
            dfs(i)


def bfs(start):
    queue = deque([start])
    visited_bfs[start] = True

    while queue:
        v = queue.popleft()
        print(v, end=" ")
        for i in graph[v]:
            if not visited_bfs[i]:
                visited_bfs[i] = True
                queue.append(i)

for i in graph:
    i.sort()

dfs(V)
print()
bfs(V)


