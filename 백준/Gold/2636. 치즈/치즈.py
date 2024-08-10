# 2636
# 치즈

import sys
from collections import deque

input = sys.stdin.readline

def bfs(start_x, start_y, cheeses):
    dx = [-1, 1, 0, 0] # 방향 벡터
    dy = [0, 0, -1, 1]

    queue = deque([(start_x, start_y)])
    visited = set([(start_x, start_y)])
    melt = deque([])

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < len(cheeses) and 0 <= ny < len(cheeses[0]):
                if (nx, ny) not in visited:
                    visited.add((nx, ny))
                    if cheeses[nx][ny] == 0: # 공기라면 계속 탐색해야하므로 queue에 추가
                        queue.append((nx, ny))
                    elif cheeses[nx][ny] == 1: # 치즈라면 녹여야하니까 melt에 추가
                        melt.append((nx, ny))

    
    for x, y in melt:
        cheeses[x][y] = 0
    return len(melt)

N, M = map(int, input().split(" "))

cheeses = []
cnt = 0

for i in range(N):
    cheeses.append(list(map(int, input().split())))
    cnt += sum(cheeses[i]) # 치즈 개수만 세기

time = 1

while True:
    meltCnt = bfs(0, 0, cheeses)
    cnt -= meltCnt
    if cnt == 0:
        print(time)
        print(meltCnt)
        break
    time += 1