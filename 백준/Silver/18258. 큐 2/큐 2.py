import sys
from collections import deque

n = int(sys.stdin.readline())
q = deque([])

for _ in range(n):
    a = sys.stdin.readline().split()
    if a[0] == 'push':
        q.append(a[1])
    elif a[0] == 'pop':
        if not q:
            print(-1)
        else:
            print(q.popleft())
    elif a[0] == 'size':
        print(len(q))
    elif a[0] == 'empty':
        if not q:
            print(1)
        else:
            print(0)
    elif a[0] == 'front':
        if not q:
            print(-1)
        else:
            print(q[0])
    elif a[0] == 'back':
        if not q:
            print(-1)
        else:
            print(q[-1])
