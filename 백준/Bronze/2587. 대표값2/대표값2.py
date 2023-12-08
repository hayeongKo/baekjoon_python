import sys

input = sys.stdin.readline

lst = []

for i in range(0, 5):
    lst.append(int(input()))

print(int(sum(lst)/5))
print(sorted(lst)[2])
