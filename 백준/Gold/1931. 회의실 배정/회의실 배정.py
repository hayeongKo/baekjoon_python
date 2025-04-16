import sys

input = sys.stdin.readline

N = int(input())
lst_schedule = []

for _ in range(N):
    lst_schedule.append(list(map(int, input().split())))

lst_schedule.sort(key = lambda arr: (arr[1], arr[0]))

count = 0
end = 0
start = 0
for i in range(N):
    if end <= lst_schedule[i][0]:
        end = lst_schedule[i][1]
        count += 1

print(count)