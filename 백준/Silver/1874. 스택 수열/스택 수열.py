n = int(input())

top = 1
flag = 0
stack = []
answer = []

for _ in range(n):
    a = int(input())
    while top <= a:
        stack.append(top)
        answer.append('+')
        top += 1

    if stack[-1] == a:
        stack.pop()
        answer.append('-')
    else:
        print('NO')
        flag = 1
        break

if flag == 0:
    for i in answer:
        print(i)