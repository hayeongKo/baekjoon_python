import sys

input = sys.stdin.readline

n = int(input())

d = [0] * 12
d[1] = 1
d[2] = 2
d[3] = 4

for i in range(4, 12):
    d[i] = sum(d[i-3:i])

for _ in range(n):
    k = int(input())
    print(d[k])
