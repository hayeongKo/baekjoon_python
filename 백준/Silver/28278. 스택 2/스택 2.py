import sys

input = sys.stdin.readline


stack = []

for _ in range(int(input())):
    promt = input().removesuffix("\n")
    if len(promt) > 1:
        lst = list(promt.split())
        stack.append(lst.pop())
    elif promt == "2":
        if len(stack) == 0:
            print("-1")
        else:
            print(stack.pop())
    elif promt == "3":
        print(len(stack))
    elif promt == "4":
        if len(stack) == 0:
            print("1")
        else:
            print("0")
    elif promt == "5":
        if len(stack) != 0:
            print(stack[len(stack)-1])
        else:
            print("-1")

