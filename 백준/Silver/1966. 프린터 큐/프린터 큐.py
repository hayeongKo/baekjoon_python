from collections import deque

n = int(input())

for _ in range(n):
    N, M = map(int, input().split())
    q = deque(input().split())
    cnt = 0
    value = int(q[M])
    pos = M
    answer = 0

    while True:
        m = int(max(q))
        pop = int(q.popleft())

        if pop == m:
            answer += 1
            if cnt == pos:
                print(answer)
                break
        else:
            q.append(str(pop))
            if cnt == pos:
                pos += len(q)

        cnt += 1