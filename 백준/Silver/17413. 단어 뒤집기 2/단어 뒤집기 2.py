# 17414
# 단어 뒤집기2

import sys
from collections import deque

input = sys.stdin.readline
stack = deque([])
tag = []
in_stack = 0
between_stack = 0
string = input().rstrip()

def print_stack(stack):
    for _ in range(len(stack)):
        print(stack.pop(), end="")

for i in string:
    # if (i == "<" and between_stack == 1):
    #     print_stack(stack)
    #     between_stack = 0
    
    if (i == " " and in_stack == 0):
        print_stack(stack)
        print(" ", end="")
        continue

    if i == "<":
        print_stack(stack)
        tag.append(i)
        in_stack = 1
    elif i != "<" and i != ">" and in_stack == 1:
        tag.append(i)
    elif i == ">":
        print(''.join(tag) + i, end="")
        tag = []
        in_stack = 0
        between_stack = 1
    else:
        stack.append(i)

print_stack(stack)