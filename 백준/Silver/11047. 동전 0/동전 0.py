a, b = map(int, input().split())
n_list = list()

for _ in range(a):
    n_list.append(int(input()))

result = 0
for i in reversed(range(a)):
    result += b//n_list[i]
    b = b%n_list[i]

print(result)