import sys

input = sys.stdin.readline

total_lst = [[] for _ in range(50+1)]

for _ in range(int(input())):
    word = str(input().removesuffix("\n"))
    total_lst[len(word)].append(word)


for word_set in total_lst:
    for k in sorted(list(set(word_set))):
        print(k)

