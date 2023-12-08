import sys

input = sys.stdin.readline
n, k = map(int, input().split())
info = []
info.append("0")

for index in range(n):
    info.append(input().removesuffix("\n"))

for q in range(k):
    question = input().removesuffix("\n")
    try:
        int(question)
    except ValueError:
        print(info.index(question))
    else:
        print(info[int(question)])
