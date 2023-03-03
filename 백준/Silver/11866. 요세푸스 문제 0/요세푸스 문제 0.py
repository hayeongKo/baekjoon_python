from collections import deque

q = deque([])
answer = []

N, K = map(int, input().split())

for i in range(1, N+1):
    q.append(i)

print('<', end='')
while True:
    if len(q) == 1:
        print(q.pop(), end='')
        break
    if len(q) >= K:
        q.rotate(-K)
    else:
        q.rotate(-(K%len(q)))
    print(q.pop(), end=', ')

print('>')