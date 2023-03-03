from collections import deque

q = deque([])
n = int(input())

for i in range(1, n+1):
    q.append(i)

i = 1

while True:
    if len(q) == 1:
        break
    if i%2 == 1:
        q.popleft()
    else:
        a = q.popleft()
        q.append(a)
    i += 1

print(q.pop())