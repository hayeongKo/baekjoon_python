import sys

input = sys.stdin.readline

n_lst = []
for i in range(int(input())):
    lst = []
    a, b = map(int, input().split())
    lst.append(b)
    lst.append(a)
    n_lst.append(lst)


for lst in sorted(n_lst):
    print(lst[1], lst[0])

