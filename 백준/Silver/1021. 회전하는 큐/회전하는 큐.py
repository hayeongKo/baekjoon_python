from collections import deque

q = deque([])

N, M = map(int, input().split())
for i in range(1, N+1):
    q.append(i)

ks = list(map(int, input().split()))

answer = 0

for k in range(len(ks)):
    pos = q.index(ks[k])

    if pos > len(q) / 2:
        q.rotate(len(q)-pos)
        answer += (len(q)-pos)
    else:
        q.rotate(-pos)
        answer += pos

    q.popleft()

print(answer)