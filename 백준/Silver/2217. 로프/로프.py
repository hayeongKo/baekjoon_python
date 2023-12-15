import sys

input = sys.stdin.readline
weights = []

for _ in range(int(input())):
    weights.append(int(input()))

weights.sort(reverse=True)

i = 1
answer = weights[0]

while True:
    if (i == len(weights)):
        break
    if answer < weights[i]*(i+1):
        answer = weights[i]*(i+1)
    i += 1

print(answer)