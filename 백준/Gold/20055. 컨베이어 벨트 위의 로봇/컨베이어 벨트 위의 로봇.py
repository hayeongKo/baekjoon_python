import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split(" "))

belt = deque(list(map(int, input().split(" "))))
robots = deque([False for _ in range(len(belt))])

answer = 0

while True:
    if K <= 0:
		    break
    
    # 벨트 회전 & 로봇도 같이 돌아
    belt.rotate(1)
    robots.rotate(1)

    # 내리는 위치에 있는 로봇은 내리기
    robots[N-1] = False

    # 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동
    for i in range(N-2, -1, -1):
        if belt[i+1] > 0 and not robots[i+1] and robots[i]:
            belt[i+1] -= 1
            robots[i+1], robots[i] = True, False
            if belt[i+1] == 0:
                K -= 1

    # 로봇 위치가 변했기 때문에 다시 내리는 위치에 있는 로봇 내리기
    robots[N-1] = False
    
    # 올리는 위치에 있는 칸의 내구도가 0이 아니라면 로봇을 올린다
    if belt[0] > 0:
        belt[0] -= 1
        robots[0] = True
        if belt[0] == 0:
            K -= 1

    answer += 1
    
print(answer)