from collections import deque

n = int(input())

for _ in range(n):
    ss = input()
    N = int(input())
    q = deque(input()[1:-1].split(','))
    
    flag = 0
    
    if N == 0:
        q = []

    for s in ss:
        if s == 'R':
            flag += 1
        elif s == 'D':
            if len(q) == 0:
                print('error')
                break

            if flag % 2 == 1:
                q.pop()
            else:
                q.popleft()

    else:
        if flag % 2 == 0:
            print("[" + ",".join(q) + "]")
        else:
            q.reverse()
            print("[" + ",".join(q) + "]")



