# 14503
# 로봇청소기

import sys

# 회전벡터 -> 반시계로 회전
dCircle = [3, 0, 1, 2]

# 방향벡터
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

input = sys.stdin.readline
N, M = map(int, input().split(" "))
r, c, d = map(int, input().split(" "))
room = []

for _ in range(N):
    room.append(list(map(int, input().split(" "))))

answer = 0

while True:
    if room[r][c] == 0: # 1. 현재 칸이 아직 청소가 안되어 있는 경우
        # 현재 칸 청소
        room[r][c] = 2
        answer += 1
    elif room[r-1][c] and room[r+1][c] and room[r][c+1] and room[r][c-1]: # 2. 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        # 바라보는 방향을 유지한채로 한칸 후진
        r -= dr[d]
        c -= dc[d]

        if room[r][c] == 1: # 벽일 경우
            break
    else: # 3. 주변 4 칸 중 청소되지 않은 칸이 있을 경우
        d = dCircle[d] # 반시계 방향으로 회전
        while room[r+dr[d]][c+dc[d]]: # 바라보는 방향을 기준으로 앞쪽 칸이 청소되어 있으면
            d = dCircle[d] # 청소 안된 빈 칸이 나올 때까지 반시계로 회전
        r += dr[d] # 앞이 청소 안된 빈칸인 경우 한 칸 전진
        c += dc[d]

print(answer)