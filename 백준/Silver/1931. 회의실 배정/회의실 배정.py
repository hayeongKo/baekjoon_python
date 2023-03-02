n = int(input())
n_list = list()

for _ in range(n):
    a, b = map(int, input().split())
    n_list.append([a, b])

n_list.sort()

result = 0
pointer = 0

for _ in range(n):
    if pointer <= n_list[_][0]:
        pointer = n_list[_][1]
        result += 1
    elif pointer > n_list[_][1]:
        pointer = n_list[_][1]

print(result)