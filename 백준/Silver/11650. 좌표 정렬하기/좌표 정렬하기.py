import sys

input = sys.stdin.readline

n_lst = []
for i in range(int(input())):
    n_lst.append(list(map(int, input().split())))

for lst in sorted(n_lst):
    print(lst[0], lst[1])
