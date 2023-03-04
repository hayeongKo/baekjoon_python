N, M = map(int, input().split())

s = set()
for _ in range(N):
    i = input()
    s.add(i)

result = 0
for _ in range(M):
    if input() in s:
        result += 1

print(result)