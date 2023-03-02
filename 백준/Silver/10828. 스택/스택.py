import sys
n = int(sys.stdin.readline())
stack = list()
for _ in range(n):
    a = sys.stdin.readline().split()
    if a[0] == 'push':
        b = a[1]
        stack.append(b)
    elif a[0] == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())
    elif a[0] == 'size':
        print(len(stack))
    elif a[0] == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    else:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[len(stack)-1])