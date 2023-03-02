n = int(input())
people = list(map(int, input().split()))

people.sort()
result = 0

for _ in range(n+1):
    for i in range(_):
        result += int(people[i])

print(result)