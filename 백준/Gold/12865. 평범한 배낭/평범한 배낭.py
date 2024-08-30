import sys

input = sys.stdin.readline
n, k = map(int, input().split())
items = [[0, 0]]
d = [[0]*(k+1) for _ in range(n+1)]

for i in range(n):
    items.append((list(map(int, input().split()))))

for i in range(1, n+1):
    for j in range(1, k+1):
        weight = items[i][0]
        value = items[i][1]

        if j < weight:
            d[i][j] = d[i-1][j]
        else:
            d[i][j] = max(d[i-1][j], d[i-1][j-weight]+value)

print(d[n][k])